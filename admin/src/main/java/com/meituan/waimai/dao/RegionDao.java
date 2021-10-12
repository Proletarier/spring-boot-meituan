package com.meituan.waimai.dao;

import com.meituan.waimai.dto.RegionWithChildrenItem;

import java.util.List;

public interface RegionDao {

    List<RegionWithChildrenItem> listWithChildren();
}
