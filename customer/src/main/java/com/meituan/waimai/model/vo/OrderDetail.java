package com.meituan.waimai.model.vo;

import lombok.Data;

import java.util.List;

@Data
public class OrderDetail {

    private String shopName;
    private Boolean exclusiveDelivery;
    private String imageUrl;
    private Double boxFee;
    private Double deliverFee;
    private Double fullReductionFee;
    private Double totalPrice;
    private Double totalDiscountPrice;
    private Double couponPrice;
    private Long deliverTime;
    private AddressInfo addressInfo;
    private List<Cart> foodList;
    private List<CouponDetailVo> couponDetailVos;
    private Integer couponId;

    @Data
    public static class Cart {
        private Integer foodId;
        private Integer count;
        private String foodImage;
        private String foodName;
        private String unit;
        private Double currentAmount;
        private Double originAmount;
        private Double boxPrice;
        private List<FoodAttributeValue> attributeValue;
    }

    @Data
    public static class CouponDetailVo {
        private Integer couponValid;
        private List<CouponInfo> couponInfoList;
    }

}
