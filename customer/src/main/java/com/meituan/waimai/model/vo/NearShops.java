package com.meituan.waimai.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NearShops {

    private  Integer count;
    private List<ShopProfile> shopVoList;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ShopProfile> getShopVoList() {
        return shopVoList;
    }

    public void setShopVoList(List<ShopProfile> shopVoList) {
        this.shopVoList = shopVoList;
    }


    @Data
    public static class ShopProfile {

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

}
