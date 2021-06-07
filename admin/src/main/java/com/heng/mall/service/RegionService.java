package com.heng.mall.service;

import com.heng.mall.dto.RegionWithChildrenItem;

import java.util.List;

public interface RegionService {

    /**
     * 获取城市及区域
     */
    List<RegionWithChildrenItem> listWithChildren();
}
