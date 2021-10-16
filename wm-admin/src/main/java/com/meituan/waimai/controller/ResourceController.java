package com.meituan.waimai.controller;


import com.meituan.waimai.common.api.CommonPage;
import com.meituan.waimai.common.api.CommonResult;
import com.meituan.waimai.dto.ResourceQueryParam;
import com.meituan.waimai.model.Resource;
import com.meituan.waimai.service.ResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags = "资源管理")
@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService service;

    @ApiOperation("创建资源")
    @PutMapping("/create")
    public CommonResult create(@RequestBody Resource resource) {
        int count = service.create(resource);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("更新资源")
    @PostMapping("/update")
    public CommonResult update(@RequestBody Resource resource) {
        int count = service.update(resource);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("列表")
    @GetMapping("/list")
    public CommonResult<CommonPage<Resource>> list(ResourceQueryParam queryParam) {
        List<Resource> list = service.list(queryParam);
        return CommonResult.success(CommonPage.restPage(list));
    }


    @ApiOperation("根据id查询商家详情")
    @GetMapping("/{id}")
    public CommonResult<Resource> getItem(@PathVariable Integer id) {
        Resource resource = service.getItem(id);
        return CommonResult.success(resource);
    }
}
