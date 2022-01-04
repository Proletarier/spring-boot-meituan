package com.meituan.waimai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.meituan.waimai.dto.ResourceQueryParam;
import com.meituan.waimai.model.Resource;

import java.util.List;

public interface ResourceService extends IService<Resource> {

    List<Resource> list(ResourceQueryParam queryParam);

}
