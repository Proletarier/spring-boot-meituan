package com.heng.mall.controller;

import com.heng.mall.common.api.CommonPage;
import com.heng.mall.common.api.CommonResult;
import com.heng.mall.model.ResourceCategory;
import com.heng.mall.service.ResourceCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "资源分类")
@RestController
@RequestMapping("/resourceCate")
public class ResourceCategoryController {

    @Autowired
    private ResourceCategoryService service;

    @ApiOperation("创建资源分类")
    @PutMapping("/create")
    public CommonResult create(@RequestBody ResourceCategory resource) {
        int count = service.create(resource);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("更新资源分类")
    @PostMapping("/update")
    public CommonResult update(@RequestBody ResourceCategory resource) {
        int count = service.update(resource);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("列表")
    @GetMapping("/list")
    public CommonResult<CommonPage<ResourceCategory>> list() {
        List<ResourceCategory> list = service.listAll();
        return CommonResult.success(CommonPage.restPage(list));
    }


}
