package com.meituan.waimai.dao;

import com.meituan.waimai.dto.ShopCategoryWithChildrenItem;

import java.util.List;

public interface ShopCategoryDao {

    List<ShopCategoryWithChildrenItem> listWithChildren();
}
