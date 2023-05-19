package com.meituan.waimai.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NearShops {

    private  Integer count;
    private List<ShopVo> shopVoList;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ShopVo> getShopVoList() {
        return shopVoList;
    }

    public void setShopVoList(List<ShopVo> shopVoList) {
        this.shopVoList = shopVoList;
    }


}
