package com.meituan.waimai.controller;

import com.meituan.waimai.common.domain.CommonPage;
import com.meituan.waimai.common.domain.CommonResult;
import com.meituan.waimai.model.ResourceCategory;
import com.meituan.waimai.service.ResourceCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "资源分类")
@RestController
@RequestMapping("/resourceCate")
public class ResourceCategoryController {

    @Autowired
    private ResourceCategoryService categoryService;

    @ApiOperation("创建资源分类")
    @PutMapping("/create")
    public CommonResult create(@RequestBody ResourceCategory resource) {
        return categoryService.save(resource) ? CommonResult.success(): CommonResult.failed();
    }

    @ApiOperation("更新资源分类")
    @PostMapping("/update")
    public CommonResult update(@RequestBody ResourceCategory resource) {
        return categoryService.updateById(resource)? CommonResult.success(): CommonResult.failed();
    }

    @ApiOperation("列表")
    @GetMapping("/list")
    public CommonResult<CommonPage<ResourceCategory>> list() {
        return CommonResult.success(CommonPage.restPage(categoryService.list()));
    }


}
