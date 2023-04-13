package com.meituan.waimai.model.vo;

import com.meituan.waimai.model.Discount;
import lombok.Data;

import java.util.List;

@Data
public class ShopVo {

    private Long id;
    private String shopName;
    private String picUrl;
    private Float shopScore;
    private String  monthSalesTip;
    private String  deliveryTimeTip;
    private String  distance;
    private String  minPriceTip;
    private String  shippingFeeTip;
    private String  averagePriceTip;
    private List<Discount> discountList;
}
