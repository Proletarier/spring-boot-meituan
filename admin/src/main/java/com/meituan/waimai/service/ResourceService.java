package com.meituan.waimai.service;

import com.meituan.waimai.dto.ResourceQueryParam;
import com.meituan.waimai.model.Resource;

import java.util.List;

public interface ResourceService {

    List<Resource> list(ResourceQueryParam queryParam);

    int create(Resource resource);

    int update(Resource resource);

    Resource getItem(Integer id);

    List<Resource> listAll();

}
