package com.meituan.waimai.dao;

import com.meituan.waimai.dto.ProductAttributeCategoryResult;

import java.util.List;

public interface ProductAttributeCategoryDao {

    List<ProductAttributeCategoryResult> listProductAttributeCategory(Integer shopId);
}
