package com.meituan.waimai.server;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.collect.Lists;
import com.meituan.waimai.bean.CustomerContext;
import com.meituan.waimai.bean.GeoPoint;
import com.meituan.waimai.common.util.DistanceCalculator;
import com.meituan.waimai.mapper.CategoryMapper;

import com.meituan.waimai.mapper.NearShopMapper;
import com.meituan.waimai.model.Category;

import com.meituan.waimai.model.Shop;
import com.meituan.waimai.model.dto.ShopFilter;
import com.meituan.waimai.model.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;


@Slf4j
@Service
public class ShopServer {

    @Autowired
    NearShopMapper shopMapper;
    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    ActivityService activityService;

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
        List<ShopVo> shops = shopMapper.selectNearShopMapper(shopFilter, cateIds, offSet);
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
        Shop shop = shopMapper.selectById(shopId);
        ShopInfo shopInfo = new ShopInfo();
        if (shop != null) {
            shopInfo.setShopName(shop.getShopName());
            shopInfo.setShopPic(shop.getPicUrl());
            shopInfo.setBulletin(shop.getBulletin());
            shopInfo.setPoint(shop.getLocation());
            shopInfo.setShopAddress(shop.getAddress());
            shopInfo.setDeliveryType(shop.getExclusiveDelivery());

            if (StrUtil.isNotEmpty(shop.getPhone())) {
                shopInfo.setShopPhone(shop.getPhone().split(","));
            }
            JSONObject saleData = shop.getSale();
            if (saleData != null) {
                shopInfo.setMinFee(saleData.getInteger("minPrice"));
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


}
