package com.heng.mall.dto;

import com.heng.mall.model.Product;
import com.heng.mall.model.ProductAttributeValue;
import com.heng.mall.model.ProductCategoryRelation;
import com.heng.mall.model.ProductDetail;
import lombok.Data;

import java.util.List;


@Data
public class ProductInfo extends Product {

    private List<ProductDetail> detailList;

    private List<ProductAttributeValue> attributeValueList;
}
