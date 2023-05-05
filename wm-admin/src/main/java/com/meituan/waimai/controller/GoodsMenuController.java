package com.meituan.waimai.controller;


import com.meituan.waimai.common.domain.CommonPage;
import com.meituan.waimai.common.domain.CommonResult;
import com.meituan.waimai.model.Menu;
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
    public CommonResult<CommonPage<Menu>> listProductCategory(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                              @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                              @RequestParam(value = "shopId") Integer shopId) {
        List<Menu> categoryList = menuService.list(pageNum, pageSize, shopId);
        return CommonResult.success(CommonPage.restPage(categoryList));
    }

    @ApiOperation("产品分类详情")
    @GetMapping("/{id}")
    public CommonResult<Menu> getItem(@PathVariable Integer id) {
        return CommonResult.success(menuService.getById(id));
    }

    @ApiOperation("修改产品分类")
    @PostMapping("/update")
    public CommonResult update(@RequestBody Menu menu) {
        return menuService.updateById(menu) ? CommonResult.success(): CommonResult.failed();
    }

    @ApiOperation("修改产品分类状态")
    @PostMapping("/update/status")
    public CommonResult updateStatus(@RequestParam(value = "id") Integer id, @RequestParam(value = "status") Integer status) {
        Menu menu = new Menu();
        menu.setId(id);
        menu.setStatus(status);
        return menuService.updateById(menu)?  CommonResult.success(): CommonResult.failed();
    }

    @ApiOperation("创建产品分类")
    @PutMapping("/create")
    public CommonResult create(@RequestBody Menu menu) {
        return menuService.save(menu)? CommonResult.success():CommonResult.failed();
    }


}
