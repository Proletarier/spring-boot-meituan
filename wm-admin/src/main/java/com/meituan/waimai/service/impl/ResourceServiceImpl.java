package com.meituan.waimai.service.impl;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.meituan.waimai.dto.ResourceQueryParam;

import com.meituan.waimai.mapper.ResourceMapper;
import com.meituan.waimai.model.Resource;
import com.meituan.waimai.service.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper,Resource> implements ResourceService{


    @Override
    public List<Resource> list(ResourceQueryParam queryParam) {
        PageHelper.startPage(queryParam.getPageNum(),queryParam.getPageSize());
        LambdaQueryWrapper<Resource> queryWrapper = new LambdaQueryWrapper();
        if (!StrUtil.isEmpty(queryParam.getName())) {
            queryWrapper.like(Resource::getName,queryParam.getName());
        }
        if (!StrUtil.isEmpty(queryParam.getUrl())) {
            queryWrapper.like(Resource::getUrl,queryParam.getUrl());
        }
        if (queryParam.getCategoryId() != null) {
            queryWrapper.eq(Resource::getCategoryId,queryParam.getCategoryId());
        }
        return list(queryWrapper);
    }

}
