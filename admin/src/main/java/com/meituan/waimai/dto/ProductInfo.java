package com.meituan.waimai.dto;


import com.meituan.waimai.model.Product;
import com.meituan.waimai.model.ProductAttributeValue;
import com.meituan.waimai.model.ProductDetail;
import lombok.Data;

import java.util.List;


@Data
public class ProductInfo extends Product {

    private List<ProductDetail> detailList;

    private List<ProductAttributeValue> attributeValueList;
}
