package com.heng.mall.controller;

import com.heng.mall.common.api.CommonPage;
import com.heng.mall.common.api.CommonResult;
import com.heng.mall.dto.ShopCategoryQueryParam;
import com.heng.mall.dto.ShopCategoryWithChildrenItem;
import com.heng.mall.model.ShopCategory;
import com.heng.mall.service.ShopCategoryService;
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
        int count = categoryService.createShopCategory(shopCategory);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改分类")
    @PostMapping("/update")
    public CommonResult update(@RequestBody ShopCategory shopCategory) {
        int count = categoryService.updateShopCategory(shopCategory);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改状态")
    @PostMapping("/update/status")
    public CommonResult updateStatus(@RequestParam("cateId") Integer cateId, @RequestParam("status") Integer status) {
        int count = categoryService.updateStatus(cateId, status);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据id查询分类")
    @GetMapping("/{cateId}")
    public CommonResult<ShopCategory> getShopCategory(@PathVariable Integer cateId) {
        ShopCategory category = categoryService.getShopCategory(cateId);
        return CommonResult.success(category);
    }

    @ApiOperation("查询分类及子类")
    @GetMapping("/children")
    public CommonResult<List<ShopCategoryWithChildrenItem>> listWithChildrenMap() {
        List<ShopCategoryWithChildrenItem> list = categoryService.listWithChildrenMap();
        return CommonResult.success(list);
    }

}
