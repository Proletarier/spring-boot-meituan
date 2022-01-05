package com.meituan.waimai.controller;


import com.meituan.waimai.common.api.CommonPage;
import com.meituan.waimai.common.api.CommonResult;
import com.meituan.waimai.dto.GoodsAttributeCategoryResult;
import com.meituan.waimai.model.GoodsAttributeCategory;
import com.meituan.waimai.service.GoodsAttributeCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "商品属性分类")
@RestController
@RequestMapping("/product/attrCate")
public class GoodsAttributeCategoryController {

    @Autowired
	GoodsAttributeCategoryService categoryService;

    @ApiOperation("商品属性分类查询")
    @GetMapping("/list")
    public CommonResult<CommonPage<GoodsAttributeCategory>> list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                 @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                 @RequestParam Integer shopId) {
        List<GoodsAttributeCategory> list = categoryService.list(pageSize, pageNum, shopId);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @ApiOperation("查询商品属性分类及规格")
    @GetMapping("/listAll")
    public CommonResult<List<GoodsAttributeCategoryResult>> listAll(@RequestParam Integer shopId) {
        List<GoodsAttributeCategoryResult> list = categoryService.listProductAttrCate(shopId);
        return CommonResult.success(list);
    }

    @ApiOperation("创建商品属性分类")
    @PutMapping("/create")
    public CommonResult create(@RequestBody GoodsAttributeCategory category) {
        return categoryService.save(category)? CommonResult.success(): CommonResult.failed();
    }


    @ApiOperation("修改商品属性分类")
    @PostMapping("/update")
    public CommonResult update(@RequestBody GoodsAttributeCategory category) {
        return categoryService.updateById(category)?CommonResult.success():CommonResult.failed();
    }

}
