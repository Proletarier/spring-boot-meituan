package com.meituan.waimai.service;


import com.meituan.waimai.model.Resource;

import java.util.List;

public interface AdminCacheService {

    /**
     * 获取缓存后台用户资源列表
     */
    List<Resource> getResourceList(Integer adminId);

    /**
     * 设置缓存后台用户资源列表
     */
    void setResourceList(Integer adminId, List<Resource> resourceList);
}
