package com.meituan.waimai.service;

import com.heng.mall.model.ResourceCategory;

import java.util.List;

public interface ResourceCategoryService {

    List<ResourceCategory> listAll();

    int create(ResourceCategory resourceCategory);

    int update(ResourceCategory resourceCategory);
}
