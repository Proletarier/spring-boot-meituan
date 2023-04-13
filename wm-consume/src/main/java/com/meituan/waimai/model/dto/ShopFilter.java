package com.meituan.waimai.model.dto;

public class ShopFilter {

    private Integer limit  = 10;
    private Integer nextStartIndex = 1;
    private String location;

    private ShopSort ruleSort;
    private Boolean distanceSort;
    private Boolean salesSort;

    private Boolean exclusiveDelivery;
    private String feature;
    private String averagePrice;
    private String activity;

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

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
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

    public Boolean getDistanceSort() {
        return distanceSort;
    }

    public void setDistanceSort(Boolean distanceSort) {
        this.distanceSort = distanceSort;
    }

    public Boolean getSalesSort() {
        return salesSort;
    }

    public void setSalesSort(Boolean salesSort) {
        this.salesSort = salesSort;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
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

    enum ShopSort {
        score,
        speed,
        min_shipping_fee,
        min_price,
        min_average_price,
        max_average_price;
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
