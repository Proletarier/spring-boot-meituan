package com.heng.mall.service.impl;


import cn.hutool.core.util.StrUtil;
import com.heng.mall.dto.ResourceQueryParam;
import com.heng.mall.mapper.ResourceMapper;
import com.heng.mall.model.Resource;
import com.heng.mall.model.ResourceExample;
import com.heng.mall.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public List<Resource> list(ResourceQueryParam queryParam) {
        ResourceExample example = new ResourceExample();
        ResourceExample.Criteria criteria = example.createCriteria();
        if (!StrUtil.isEmpty(queryParam.getName())) {
            criteria.andNameLike("%" + queryParam.getName() + "%");
        }
        if (!StrUtil.isEmpty(queryParam.getUrl())) {
            criteria.andUrlLike("%" + queryParam.getUrl() + "%");
        }
        if (queryParam.getCategoryId() != null) {
            criteria.andCategoryIdEqualTo(queryParam.getCategoryId());
        }
        return resourceMapper.selectByExample(example);
    }

    @Override
    public int create(Resource resource) {
        resource.setCreateTime(new Date());
        return resourceMapper.insert(resource);
    }

    @Override
    public int update(Resource resource) {
        return resourceMapper.updateByPrimaryKeySelective(resource);
    }

    @Override
    public Resource getItem(Integer id) {
        return resourceMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Resource> listAll() {
        return resourceMapper.selectByExample(new ResourceExample());
    }
}
