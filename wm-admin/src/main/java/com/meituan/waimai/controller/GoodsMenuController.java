package com.meituan.waimai.controller;


import com.meituan.waimai.common.model.entity.CommonPage;
import com.meituan.waimai.common.model.entity.CommonResult;
import com.meituan.waimai.model.GoodsMenu;
import com.meituan.waimai.service.GoodsMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "商品菜单")
@RestController
@RequestMapping("/productCate")
public class GoodsMenuController {

    @Autowired
    private GoodsMenuService menuService;


    @ApiOperation("产品分类查询")
    @GetMapping("/list")
    public CommonResult<CommonPage<GoodsMenu>> listProductCategory(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                   @RequestParam(value = "shopId") Integer shopId) {
        List<GoodsMenu> categoryList = menuService.list(pageNum, pageSize, shopId);
        return CommonResult.success(CommonPage.restPage(categoryList));
    }

    @ApiOperation("产品分类详情")
    @GetMapping("/{id}")
    public CommonResult<GoodsMenu> getItem(@PathVariable Integer id) {
        return CommonResult.success(menuService.getById(id));
    }

    @ApiOperation("修改产品分类")
    @PostMapping("/update")
    public CommonResult update(@RequestBody GoodsMenu goodsMenu) {
        return menuService.updateById(goodsMenu) ? CommonResult.success(): CommonResult.failed();
    }

    @ApiOperation("修改产品分类状态")
    @PostMapping("/update/status")
    public CommonResult updateStatus(@RequestParam(value = "id") Integer id, @RequestParam(value = "status") Integer status) {
        GoodsMenu goodsMenu = new GoodsMenu();
        goodsMenu.setId(id);
        goodsMenu.setStatus(status);
        return menuService.updateById(goodsMenu)?  CommonResult.success(): CommonResult.failed();
    }

    @ApiOperation("创建产品分类")
    @PutMapping("/create")
    public CommonResult create(@RequestBody GoodsMenu goodsMenu) {
        return menuService.save(goodsMenu)? CommonResult.success():CommonResult.failed();
    }


}
