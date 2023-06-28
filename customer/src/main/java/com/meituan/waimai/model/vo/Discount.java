package com.meituan.waimai.model.vo;

import lombok.Data;

@Data
public class Discount {

    private Integer count;
    private Integer minPurchaseNum;
    private Double discount;
}
