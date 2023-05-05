package com.meituan.waimai.model.vo;

import lombok.Data;

import java.util.List;

@Data
public class ShopVo {

    private Integer id;
    private String shopName;
    private String picUrl;
    private Float shopScore;
    private String  monthSalesTip;
    private String  deliveryTimeTip;
    private String  distance;
    private String  minPriceTip;
    private String  shippingFeeTip;
    private String  averagePriceTip;
    private List<Activity> activityList;
}
