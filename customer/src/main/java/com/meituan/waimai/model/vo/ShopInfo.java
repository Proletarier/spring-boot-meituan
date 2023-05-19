package com.meituan.waimai.model.vo;

import com.meituan.waimai.bean.GeoPoint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShopInfo {

    private String shopPic;
    private String shopName;
    private String shopAddress;
    private String[] shopPhone;
    private String shippingTime;
    private String distance;
    private Double minFee;
    private Double deliveryFee;
    private String deliveryTimeDecoded;
    private Boolean deliveryType;
    private String bulletin;
    private GeoPoint point;
    private List<Activity> activityList;
}
