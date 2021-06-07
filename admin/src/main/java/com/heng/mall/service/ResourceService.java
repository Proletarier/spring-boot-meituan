package com.heng.mall.service;

import com.heng.mall.dto.ResourceQueryParam;
import com.heng.mall.model.Resource;

import java.util.List;

public interface ResourceService {

    List<Resource> list(ResourceQueryParam queryParam);

    int create(Resource resource);

    int update(Resource resource);

    Resource getItem(Integer id);

    List<Resource> listAll();

}
