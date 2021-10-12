package com.meituan.waimai.controller;


import com.meituan.waimai.common.api.CommonPage;
import com.meituan.waimai.common.api.CommonResult;
import com.meituan.waimai.dto.ProductInfo;
import com.heng.mall.model.Product;
import com.meituan.waimai.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "商品")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation("食物列表")
    @GetMapping("/list")
    public CommonResult<CommonPage<Product>> listProduct(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                         @RequestParam(value = "shopId") Integer shopId, String name) {

        List<Product> list = productService.listProduct(pageNum, pageSize, shopId, name);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @ApiOperation("商品详情")
    @GetMapping("/{id}")
    public CommonResult<ProductInfo> getInfo(@PathVariable Integer id) {
        ProductInfo info = productService.getProductInfo(id);
        return CommonResult.success(info);
    }

    @ApiOperation("修改商品信息")
    @PostMapping("/update")
    public CommonResult update(@RequestBody ProductInfo productInfo) {
        int count = productService.update(productInfo);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("添加商品")
    @PutMapping("/create")
    public CommonResult create(@RequestBody ProductInfo productInfo) {
        int count = productService.create(productInfo);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}
