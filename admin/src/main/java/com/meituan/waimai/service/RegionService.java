package com.meituan.waimai.service;

import com.meituan.waimai.dto.RegionWithChildrenItem;

import java.util.List;

public interface RegionService {

    /**
     * 获取城市及区域
     */
    List<RegionWithChildrenItem> listWithChildren();
}
