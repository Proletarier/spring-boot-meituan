package com.meituan.waimai.service;

import com.heng.mall.model.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    List<ProductCategory> list(Integer pageNum, Integer pageSize, Integer shopId);

    ProductCategory getItem(Integer id);

    int update(ProductCategory productCategory);

    int create(ProductCategory productCategory);

    int updateStatus(Integer id, Integer status);
}
