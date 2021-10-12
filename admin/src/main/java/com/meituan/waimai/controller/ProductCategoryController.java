package com.meituan.waimai.controller;


import com.meituan.waimai.common.api.CommonPage;
import com.meituan.waimai.common.api.CommonResult;
import com.heng.mall.model.ProductCategory;
import com.meituan.waimai.service.ProductCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "商品菜单")
@RestController
@RequestMapping("/productCate")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService categoryService;


    @ApiOperation("产品分类查询")
    @GetMapping("/list")
    public CommonResult<CommonPage<ProductCategory>> listProductCategory(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                         @RequestParam(value = "shopId") Integer shopId) {
        List<ProductCategory> categoryList = categoryService.list(pageNum, pageSize, shopId);
        return CommonResult.success(CommonPage.restPage(categoryList));
    }

    @ApiOperation("产品分类详情")
    @GetMapping("/{id}")
    public CommonResult<ProductCategory> getItem(@PathVariable Integer id) {
        ProductCategory productCategory = categoryService.getItem(id);
        return CommonResult.success(productCategory);
    }

    @ApiOperation("修改产品分类")
    @PostMapping("/update")
    public CommonResult update(@RequestBody ProductCategory category) {
        int count = categoryService.update(category);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改产品分类状态")
    @PostMapping("/update/status")
    public CommonResult updateStatus(@RequestParam(value = "id") Integer id, @RequestParam(value = "status") Integer status) {
        int count = categoryService.updateStatus(id, status);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("创建产品分类")
    @PutMapping("/create")
    public CommonResult create(@RequestBody ProductCategory category) {
        int count = categoryService.create(category);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }


}
