package com.meituan.waimai.service;


import com.meituan.waimai.model.ResourceCategory;

import java.util.List;

public interface ResourceCategoryService {

    List<ResourceCategory> listAll();

    int create(ResourceCategory resourceCategory);

    int update(ResourceCategory resourceCategory);
}
