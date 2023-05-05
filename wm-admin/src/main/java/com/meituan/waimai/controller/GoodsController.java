package com.meituan.waimai.controller;


import com.meituan.waimai.common.domain.CommonPage;
import com.meituan.waimai.common.domain.CommonResult;
import com.meituan.waimai.dto.ProductInfo;
import com.meituan.waimai.model.Product;
import com.meituan.waimai.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "商品")
@RestController
@RequestMapping("/product")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @ApiOperation("食物列表")
    @GetMapping("/list")
    public CommonResult<CommonPage<Product>> listGoods(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                       @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                       @RequestParam(value = "shopId") Integer shopId, String name) {

        List<Product> list = goodsService.listGoods(pageNum, pageSize, shopId, name);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @ApiOperation("商品详情")
    @GetMapping("/{id}")
    public CommonResult<ProductInfo> getInfo(@PathVariable Integer id) {
        ProductInfo info = goodsService.getGoodsInfo(id);
        return CommonResult.success(info);
    }

    @ApiOperation("修改商品信息")
    @PostMapping("/update")
    public void update(@RequestBody ProductInfo goodsInfo) {
    }

    @ApiOperation("添加商品")
    @PutMapping("/create")
    public void create(@RequestBody ProductInfo goodsInfo) {
    }
}
