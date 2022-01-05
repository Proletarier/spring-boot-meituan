package com.meituan.waimai.dto;


import com.meituan.waimai.model.GoodsAttribute;
import com.meituan.waimai.model.GoodsAttributeCategory;
import lombok.Data;

import java.util.List;

@Data
public class GoodsAttributeCategoryResult extends GoodsAttributeCategory {

    /**
     * 产品属性
     */
    List<GoodsAttribute> productAttributeList;
}
