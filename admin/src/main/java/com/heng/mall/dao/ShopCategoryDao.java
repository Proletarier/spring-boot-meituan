package com.heng.mall.dao;

import com.heng.mall.dto.ShopCategoryWithChildrenItem;

import java.util.List;

public interface ShopCategoryDao {

    List<ShopCategoryWithChildrenItem> listWithChildren();
}
