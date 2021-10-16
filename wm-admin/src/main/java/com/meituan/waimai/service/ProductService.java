package com.meituan.waimai.service;

import com.meituan.waimai.dto.ProductInfo;
import com.meituan.waimai.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> listProduct(Integer pageNum, Integer pageSize, Integer shopId, String name);

    ProductInfo getProductInfo(Integer id);

    int update(ProductInfo productInfo);

    int create(ProductInfo productInfo);
}
