package com.meituan.waimai.service;

import com.meituan.waimai.dto.ProductAttributeCategoryResult;
import com.meituan.waimai.model.ProductAttributeCategory;

import java.util.List;

public interface ProductAttributeCategoryService {

    List<ProductAttributeCategory> list(Integer pageSize, Integer pageNum, Integer shopId);

    int create(ProductAttributeCategory category);

    int update(ProductAttributeCategory category);

    List<ProductAttributeCategoryResult> listProductAttrCate(Integer shopId);
}
