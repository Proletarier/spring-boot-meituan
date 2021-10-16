package com.meituan.waimai.service.impl;


import com.meituan.waimai.mapper.ResourceCategoryMapper;
import com.meituan.waimai.model.ResourceCategory;
import com.meituan.waimai.model.ResourceCategoryExample;
import com.meituan.waimai.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ResourceCategoryServiceImpl  implements ResourceCategoryService {

    @Autowired
    private ResourceCategoryMapper categoryMapper;

    @Override
    public List<ResourceCategory> listAll() {
        ResourceCategoryExample  example=new ResourceCategoryExample();
        return categoryMapper.selectByExample(example);
    }

    @Override
    public int create(ResourceCategory resourceCategory) {
        resourceCategory.setCreateTime(new Date());
        return categoryMapper.insert(resourceCategory);
    }

    @Override
    public int update(ResourceCategory resourceCategory) {
        return categoryMapper.updateByPrimaryKeySelective(resourceCategory);
    }
}
