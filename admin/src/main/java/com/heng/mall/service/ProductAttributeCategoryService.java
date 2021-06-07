package com.heng.mall.service;

import com.heng.mall.dto.ProductAttributeCategoryResult;
import com.heng.mall.model.ProductAttributeCategory;

import java.util.List;

public interface ProductAttributeCategoryService {

    List<ProductAttributeCategory> list(Integer pageSize, Integer pageNum, Integer shopId);

    int create(ProductAttributeCategory category);

    int update(ProductAttributeCategory category);

    List<ProductAttributeCategoryResult> listProductAttrCate(Integer shopId);
}
