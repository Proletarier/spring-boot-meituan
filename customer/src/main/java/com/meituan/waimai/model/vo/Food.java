package com.meituan.waimai.model.vo;

import lombok.Data;

import java.util.List;


@Data
public class Food {

    private Integer foodId;
    private Integer menuId;
    private String spuName;
    private String unit;
    private String spuDesc;
    private String imageUrl;
    private Double originPrice;
    private Double currentPrice;
    private Double boxFee;
    private String saleVolume;
    private String praiseNum;
    private Integer sellStatus;
    private Integer activityType;
    private String spuPromotionInfo;
    private Boolean must;

    private ActivityPolicy activityPolicy;
    private List<String> labelList;
    private List<FoodAttribute> spuAttrList;
}
