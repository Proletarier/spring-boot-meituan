package com.meituan.waimai.controller;

import com.meituan.waimai.common.api.CommonPage;
import com.meituan.waimai.common.api.CommonResult;
import com.meituan.waimai.model.ProductAttribute;
import com.meituan.waimai.service.ProductAttributeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "商品规格")
@RestController
@RequestMapping("/productAttr")
public class ProductAttributeController {

    @Autowired
    private ProductAttributeService attributeService;

    @ApiOperation("商品属性列表")
    @GetMapping("list")
    public CommonResult<CommonPage<ProductAttribute>> list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                           @RequestParam Integer cateId) {
        List<ProductAttribute> list = attributeService.list(pageNum, pageSize, cateId);
        return CommonResult.success(CommonPage.restPage(list));
    }


    @ApiOperation("创建商品属性")
    @PutMapping("/create")
    public CommonResult create(@RequestBody ProductAttribute productAttribute) {
        int count = attributeService.create(productAttribute);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改商品属性")
    @PostMapping("/update")
    public CommonResult update(@RequestBody ProductAttribute productAttribute) {
        int count = attributeService.update(productAttribute);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

}
