package com.meituan.waimai.server;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.meituan.waimai.bean.CustomerContext;
import com.meituan.waimai.bean.GeoPoint;
import com.meituan.waimai.common.util.DistanceCalculator;
import com.meituan.waimai.mapper.*;

import com.meituan.waimai.model.*;

import com.meituan.waimai.model.dto.ShopFilter;
import com.meituan.waimai.model.vo.*;
import com.meituan.waimai.model.vo.ShopComment;
import com.meituan.waimai.model.vo.ShopInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;


@Slf4j
@Service
public class ShopServer extends ServiceImpl<ShopMapper, Shop> {

    @Autowired
    NearShopMapper shopMapper;
    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    ActivityService activityService;
    @Autowired
    MenuMapper menuMapper;
    @Autowired
    FoodMapper foodMapper;
    @Autowired
    ShopCommentMapper shopCommentMapper;
    @Autowired
    CommentMapper commentMapper;

    public NearShops getNearShop(ShopFilter shopFilter) {
        int offSet = (shopFilter.getNextStartIndex() - 1) * shopFilter.getLimit();

        List<Integer> cateIds = Lists.newArrayList();
        if (shopFilter.getCategoryId() != null) {
            Category category = categoryMapper.selectById(shopFilter.getCategoryId());
            if (category.getParentId() != null) {
                cateIds.add(shopFilter.getCategoryId());
            } else {
                List<Category> cateList = categoryMapper.selectList(new LambdaQueryWrapper<Category>().eq(Category::getParentId, shopFilter.getCategoryId()));
                if (!cateList.isEmpty()) {
                    cateIds.addAll(cateList.stream().map(Category::getId).collect(Collectors.toSet()));
                }
            }
        }

        NearShops nearShops = new NearShops();
        nearShops.setCount(shopMapper.countNearShopMapper(shopFilter, cateIds));
        if (nearShops.getCount() == 0) {
            nearShops.setShopVoList(new ArrayList<>(0));
            return nearShops;
        }
        List<NearShops.ShopProfile> shops = shopMapper.selectNearShopMapper(shopFilter, cateIds, offSet);
        shops.forEach(shop -> {
            double meter = Double.parseDouble(shop.getDistance());
            if (meter < 1000) {
                shop.setDistance((int) meter + "m");
            } else {
                DecimalFormat df = new DecimalFormat("#.#km");
                shop.setDistance(df.format(meter / 1000));
            }
            int saleCount = Integer.parseInt(shop.getMonthSalesTip());
            if (saleCount > 100) {
                int value;
                if (shop.getMonthSalesTip().length() == 3) {
                    value = (saleCount / 100) % 10 * 100;
                } else if (shop.getMonthSalesTip().length() == 4) {
                    value = (saleCount / 1000) % 10 * 1000;
                } else {
                    value = 9999;
                }
                shop.setMonthSalesTip(value + "+");
            }

            shop.setActivityList(activityService.getActivity(shop.getId()));
        });
        nearShops.setShopVoList(shops);

        return nearShops;
    }

    public ShopInfo getShopInfo(Integer shopId) {
        Shop shop = getById(shopId);
        ShopInfo shopInfo = new ShopInfo();
        if (shop != null) {
            shopInfo.setShopName(shop.getShopName());
            shopInfo.setShopPic(shop.getPicUrl());
            shopInfo.setBulletin(shop.getBulletin());
            shopInfo.setPoint(shop.getLocation());
            shopInfo.setShopAddress(shop.getAddress());
            shopInfo.setDeliveryType(shop.getExclusiveDelivery());
            shopInfo.setMinFee(shop.getMinPrice());
            shopInfo.setDeliveryFee(5.0);

            if (StrUtil.isNotEmpty(shop.getPhone())) {
                shopInfo.setShopPhone(shop.getPhone().split(","));
            }
            JSONArray shippingTime = shop.getShippingTime();
            if (shippingTime != null && !shippingTime.isEmpty()) {
                StringBuilder time = new StringBuilder();
                for (int i = 0; i < shippingTime.size(); i++) {
                    if (i > 0) {
                        time.append(",");
                    }
                    time.append(shippingTime.getString(i));
                }
                shopInfo.setShippingTime(time.toString());
            }

            GeoPoint shopPoint = shop.getLocation();
            GeoPoint customerPoint = CustomerContext.getKeyLocation();
            if (shopPoint != null && customerPoint != null) {
                double meter = DistanceCalculator.calculateDistance(customerPoint.getLat(), customerPoint.getLng(), shopPoint.getLat(), shopPoint.getLng());
                if (meter < 1000) {
                    shopInfo.setDistance((int) meter + "m");
                } else {
                    DecimalFormat df = new DecimalFormat("#.#km");
                    shopInfo.setDistance(df.format(meter / 1000));
                }
            }
            shopInfo.setActivityList(activityService.getActivity(shop.getId()));
        }
        return shopInfo;
    }


    public List<FoodCategory> getFood(Integer shopId) {

        LambdaQueryWrapper<Menu> menuWrapper = new LambdaQueryWrapper();
        menuWrapper.eq(Menu::getShopId, shopId).eq(Menu::getStatus, Boolean.TRUE);
        List<Menu> menuList = menuMapper.selectList(menuWrapper);
        if (!menuList.isEmpty()) {
            List<Integer> menuIds = menuList.stream().map(Menu::getId).collect(Collectors.toList());
            List<Food> foodList = foodMapper.selectProductByMenuId(menuIds);

            List<FoodCategory> categories = menuList.stream().map(menu -> {
                FoodCategory foodCategory = new FoodCategory();
                foodCategory.setCategoryName(menu.getMenuName());
                foodCategory.setIconUrl(menu.getIcon());

                List<Food> subList = Lists.newLinkedList();
                foodList.forEach(food -> {
                    if (food.getMenuId().equals(menu.getId())) {
                        subList.add(food);
                    }
                    food.setSpuAttrList(foodMapper.selectFoodAttribute(food.getFoodId()));
                    activityService.setActivityInfo(food);
                });
                foodCategory.setSpuList(subList);
                foodList.removeAll(subList);
                return foodCategory;
            }).collect(Collectors.toList());

            return categories;
        }
        return new ArrayList<>(0);
    }


    public ShopComment getShopComment(Integer shopId) {
        Shop shop = getById(shopId);

        ShopComment shopComment = new ShopComment();
        JSONObject sale = shop.getSale();
        if (sale != null && !sale.isEmpty()) {
            JSONObject score = sale.getJSONObject("score");
            if (score != null && !score.isEmpty()) {
                shopComment.setShopScore(score.getDouble("shopScore"));
                shopComment.setPackScore(score.getDouble("packScore"));
                shopComment.setDeliveryScore(score.getDouble("deliveryScore"));
                shopComment.setQualityScore(score.getDouble("qualityScore"));
            }
        }
        List<ShopComment.CommentLabel> commentLabels = shopCommentMapper.selectCommentLabelList(shopId);
        if (!commentLabels.isEmpty()) {
            commentLabels.forEach(commentLabel -> {
                if (commentLabel.getId() == 0) {
                    commentLabel.setIsSelected(1);
                } else {
                    commentLabel.setIsSelected(0);
                }
            });
            shopComment.setCommentLabels(commentLabels);
        }
        return shopComment;
    }

    public List<CommentDetail> getCommentList(Integer shopId, Integer commentLabelId, Integer pageNum,Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        LambdaQueryWrapper<Comment> commentWrapper = new LambdaQueryWrapper();
        commentWrapper.eq(Comment::getShopId, shopId);
        if (commentLabelId !=null) {
            switch (commentLabelId){
                case 1:
                    commentWrapper.eq(Comment::getGood, Boolean.TRUE);
                    break;
                case 2:
                    commentWrapper.eq(Comment::getNegative, Boolean.TRUE);
                    break;
                case 3:
                    commentWrapper.eq(Comment::getPicture, Boolean.TRUE);
                    break;
                case 4:
                    commentWrapper.eq(Comment::getTaste, Boolean.TRUE);
                    break;
                case 5:
                    commentWrapper.eq(Comment::getService, Boolean.TRUE);
                    break;
                case 6:
                    commentWrapper.eq(Comment::getPack, Boolean.TRUE);
                    break;
                case 7:
                    commentWrapper.eq(Comment::getRecommend, Boolean.TRUE);
                    break;
                case 8:
                    commentWrapper.eq(Comment::getSatisfaction, Boolean.TRUE);
                    break;
                case 9:
                    commentWrapper.eq(Comment::getWeight, Boolean.TRUE);
                    break;
            }
        }
        List<Comment> commentList = commentMapper.selectList(commentWrapper);

        return commentList.stream().map(comment ->{
            CommentDetail detail = new CommentDetail();
            detail.setUserName(comment.getCustomerName());
            detail.setUserPicUrl(comment.getCustomerIcon());
            detail.setContent(comment.getContent());
            detail.setCommentTime(DateUtil.format(comment.getCreatedDate(),"yyyy-MM-dd"));
            detail.setDeliveryTime(comment.getDeliveryTime());
            detail.setPraiseDish(comment.getPraiseDish());
            detail.setScore(comment.getScore());
            detail.setPictures(comment.getPictures());
            detail.setShopReply(comment.getShopReply());
            return  detail;
        }).collect(Collectors.toList());
    }

}
