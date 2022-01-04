package com.meituan.waimai.controller;


import com.meituan.waimai.common.api.CommonPage;
import com.meituan.waimai.common.api.CommonResult;
import com.meituan.waimai.dto.ResourceQueryParam;
import com.meituan.waimai.model.Resource;
import com.meituan.waimai.service.ResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags = "资源管理")
@RestController
@RequestMapping("/resource")
@Slf4j
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @ApiOperation("创建资源")
    @PutMapping("/create")
    public CommonResult create(@RequestBody Resource resource) {
        log.info("resource create object :{}",resource);
        return resourceService.save(resource)? CommonResult.success():CommonResult.failed();
    }

    @ApiOperation("更新资源")
    @PostMapping("/update")
    public CommonResult update(@RequestBody Resource resource) {
        log.info("resource update object :{}",resource);
        return resourceService.updateById(resource)? CommonResult.success():CommonResult.failed();
    }

    @ApiOperation("列表")
    @GetMapping("/list")
    public CommonResult<CommonPage<Resource>> list(ResourceQueryParam queryParam) {
        log.info("resource list query param : {}",queryParam);
        List<Resource> resourceList = resourceService.list(queryParam);
        return CommonResult.success(CommonPage.restPage(resourceList));
    }


    @ApiOperation("根据id查询商家详情")
    @GetMapping("/{id}")
    public CommonResult<Resource> getItem(@PathVariable Integer id) {
        log.info("resource detail id :{}",id);
        return CommonResult.success(resourceService.getById(id));
    }
}
