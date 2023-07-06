package com.meituan.waimai.model.vo;

import lombok.Data;

@Data
public class CouponInfo {

    private Integer id;
    private Integer couponId;
    private Integer couponType;
    private String title;
    private String priceLimit;
    private Double amount;
    private String useLimits;
    private String timeLimit;
}
