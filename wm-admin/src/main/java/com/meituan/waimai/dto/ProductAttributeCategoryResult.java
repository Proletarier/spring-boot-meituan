package com.meituan.waimai.dto;


import com.meituan.waimai.model.ProductAttribute;
import com.meituan.waimai.model.ProductAttributeCategory;
import lombok.Data;

import java.util.List;

@Data
public class ProductAttributeCategoryResult extends ProductAttributeCategory {

    /**
     * 产品属性
     */
    List<ProductAttribute> productAttributeList;
}
