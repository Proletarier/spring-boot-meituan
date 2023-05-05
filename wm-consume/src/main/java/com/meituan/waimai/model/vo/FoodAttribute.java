package com.meituan.waimai.model.vo;

import lombok.Data;

import java.util.List;

@Data
public class FoodAttribute {

    private String attributeName;
    private List<FoodAttributeValue> spuAttrValueList;
}
