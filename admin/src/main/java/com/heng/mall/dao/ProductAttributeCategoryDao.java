package com.heng.mall.dao;

import com.heng.mall.dto.ProductAttributeCategoryResult;

import java.util.List;

public interface ProductAttributeCategoryDao {

    List<ProductAttributeCategoryResult> listProductAttributeCategory(Integer shopId);
}
