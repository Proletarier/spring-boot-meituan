package com.meituan.waimai.dto;

import com.heng.mall.model.ProductAttribute;
import com.heng.mall.model.ProductAttributeCategory;
import lombok.Data;

import java.util.List;

@Data
public class ProductAttributeCategoryResult extends ProductAttributeCategory {

    /**
     * 产品属性
     */
    List<ProductAttribute> productAttributeList;
}
