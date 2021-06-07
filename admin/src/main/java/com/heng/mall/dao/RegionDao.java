package com.heng.mall.dao;

import com.heng.mall.dto.RegionWithChildrenItem;

import java.util.List;

public interface RegionDao {

    List<RegionWithChildrenItem> listWithChildren();
}
