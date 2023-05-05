package com.meituan.waimai.dto;


import com.meituan.waimai.model.Product;
import com.meituan.waimai.model.ProductAttributeValue;
import lombok.Data;

import java.util.List;


@Data
public class ProductInfo extends Product {


    private List<ProductAttributeValue> attributeValueList;
}
