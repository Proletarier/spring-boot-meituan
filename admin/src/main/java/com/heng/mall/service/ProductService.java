package com.heng.mall.service;

import com.heng.mall.dto.ProductInfo;
import com.heng.mall.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> listProduct(Integer pageNum, Integer pageSize, Integer shopId, String name);

    ProductInfo getProductInfo(Integer id);

    int update(ProductInfo productInfo);

    int create(ProductInfo productInfo);
}
