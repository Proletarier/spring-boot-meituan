package com.meituan.waimai.controller;

import com.meituan.waimai.common.model.entity.CommonPage;
import com.meituan.waimai.common.model.entity.CommonResult;
import com.meituan.waimai.dto.ShopCategoryQueryParam;
import com.meituan.waimai.dto.ShopCategoryWithChildrenItem;
import com.meituan.waimai.model.ShopCategory;
import com.meituan.waimai.service.ShopCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "商家分类")
@RestController
@RequestMapping("/shopCategory")
public class ShopCategoryController {

    @Autowired
    private ShopCategoryService categoryService;

    @ApiOperation("分类列表")
    @GetMapping("/list")
    public CommonResult<CommonPage<ShopCategory>> list(ShopCategoryQueryParam param,
                                                       @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                       @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ShopCategory> list = categoryService.list(param, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @ApiOperation("创建分类")
    @PutMapping("/create")
    public CommonResult create(@RequestBody ShopCategory shopCategory) {
        return  categoryService.createShopCategory(shopCategory)? CommonResult.success(): CommonResult.failed();
    }

    @ApiOperation("修改分类")
    @PostMapping("/update")
    public CommonResult update(@RequestBody ShopCategory shopCategory) {
        return categoryService.updateById(shopCategory) ? CommonResult.success(): CommonResult.failed();
    }

    @ApiOperation("修改状态")
    @PostMapping("/update/status")
    public CommonResult updateStatus(@RequestParam("cateId") Integer cateId, @RequestParam("status") Integer status) {
        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setId(cateId);
        return categoryService.updateById(shopCategory) ? CommonResult.success(): CommonResult.failed();
    }

    @ApiOperation("根据id查询分类")
    @GetMapping("/{cateId}")
    public CommonResult<ShopCategory> getShopCategory(@PathVariable Integer cateId) {
        return CommonResult.success(categoryService.getById(cateId));
    }

    @ApiOperation("查询分类及子类")
    @GetMapping("/children")
    public CommonResult<List<ShopCategoryWithChildrenItem>> listWithChildrenMap() {
        List<ShopCategoryWithChildrenItem> list = categoryService.listWithChildrenMap();
        return CommonResult.success(list);
    }

}
