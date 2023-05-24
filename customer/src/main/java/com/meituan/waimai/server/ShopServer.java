package com.meituan.waimai.server;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.meituan.waimai.bean.CustomerContext;
import com.meituan.waimai.bean.GeoPoint;
import com.meituan.waimai.common.util.DistanceCalculator;
import com.meituan.waimai.mapper.*;

import com.meituan.waimai.model.*;

import com.meituan.waimai.model.dto.ShopFilter;
import com.meituan.waimai.model.vo.*;
import com.meituan.waimai.model.vo.Comment;
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


    public Comment getShopComment(Integer shopId) {
        Shop shop = getById(shopId);

        Comment comment = new Comment();
        JSONObject sale = shop.getSale();
        if (sale != null && !sale.isEmpty()) {
            JSONObject score = sale.getJSONObject("score");
            if (score != null && !score.isEmpty()) {
                comment.setShopScore(score.getDouble("shopScore"));
                comment.setPackScore(score.getDouble("packScore"));
                comment.setDeliveryScore(score.getDouble("deliveryScore"));
                comment.setQualityScore(score.getDouble("qualityScore"));
            }
        }
        List<Comment.CommentLabel> commentLabels = shopCommentMapper.selectCommentLabelList(shopId);
        if (!commentLabels.isEmpty()) {
            commentLabels.forEach(commentLabel -> {
                if (commentLabel.getId() == 0) {
                    commentLabel.setIsSelected(1);
                } else {
                    commentLabel.setIsSelected(0);
                }
            });
            comment.setCommentLabels(commentLabels);
        }
        return comment;
    }

    public List<CommentDetail> getCommentList(Integer shopId, Integer commentLabelId, Integer pageIndex) {

        LambdaQueryWrapper<com.meituan.waimai.model.Comment> commentWrapper = new LambdaQueryWrapper();
        commentWrapper.eq(com.meituan.waimai.model.Comment::getShopId, shopId);
        if (!CommentLabelEnum.comment_label_all.equals(commentLabelId)) {
           // commentWrapper.eq()
        }
        return null;
    }

    public static class CommentLabelEnum {
        public static Integer comment_label_all = 0;
        public static Integer comment_label_good = 1;
        public static Integer comment_label_negative = 2;
        public static Integer comment_label_picture = 3;
        public static Integer comment_label_taste = 4;
        public static Integer comment_label_service = 5;
        public static Integer comment_label_pack = 6;
        public static Integer comment_label_recommend = 7;
        public static Integer comment_label_satisfaction = 8;
        public static Integer comment_label_weight = 9;
    }

}
