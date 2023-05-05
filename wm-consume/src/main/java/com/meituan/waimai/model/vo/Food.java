package com.meituan.waimai.model.vo;

import lombok.Data;

import java.util.List;


@Data
public class Food {

    private Integer foodId;
    private String spuName;
    private String unit;
    private String spuDesc;
    private String imageUrl;
    private Double originPrice;
    private Double currentPrice;
    private Double boxFee;
    private String saleVolumeDecoded;
    private String praiseNumDecoded;
    private Integer sellStatus;
    private Integer activityType;
    private String spuPromotionInfo;

    private List<FoodAttribute> spuAttrList;
}
