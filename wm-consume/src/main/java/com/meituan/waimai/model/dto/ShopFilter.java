package com.meituan.waimai.model.dto;

import com.meituan.waimai.bean.GeoPoint;

import java.util.List;

public class ShopFilter {

    private Integer limit  = 5;
    private Integer nextStartIndex = 1;
    private GeoPoint location;
    private ShopSort ruleSort;
    private List<ShopFeature> feature;
    private Boolean exclusiveDelivery;

    private String averagePrice;
    private String activity;
    private Integer categoryId;


    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(String averagePrice) {
        this.averagePrice = averagePrice;
    }


    public Boolean getExclusiveDelivery() {
        return exclusiveDelivery;
    }

    public void setExclusiveDelivery(Boolean exclusiveDelivery) {
        this.exclusiveDelivery = exclusiveDelivery;
    }

    public ShopSort getRuleSort() {
        return ruleSort;
    }

    public void setRuleSort(ShopSort ruleSort) {
        this.ruleSort = ruleSort;
    }

    public GeoPoint getLocation() {
        return location;
    }

    public void setLocation(GeoPoint location) {
        this.location = location;
    }

    public Integer getNextStartIndex() {
        return nextStartIndex;
    }

    public void setNextStartIndex(Integer nextStartIndex) {
        this.nextStartIndex = nextStartIndex;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public List<ShopFeature> getFeature() {
        return feature;
    }

    public void setFeature(List<ShopFeature> feature) {
        this.feature = feature;
    }

    enum ShopSort {
        score,
        speed,
        distance,
        sales,
        min_shipping_fee,
        min_price,
        min_average_price,
        max_average_price,
        synthesize
    }

    enum ShopFeature {
        free_average_price,
        not_limit_delivery,
        new_shop,
        brand_shop,
        high_mark,
        reserve,
        invoice
    }
}
