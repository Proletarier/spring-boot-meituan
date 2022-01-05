package com.meituan.waimai.dao;

import com.meituan.waimai.dto.GoodsAttributeCategoryResult;

import java.util.List;

public interface GoodsAttributeCategoryDao {

    List<GoodsAttributeCategoryResult> listProductAttributeCategory(Integer shopId);
}
