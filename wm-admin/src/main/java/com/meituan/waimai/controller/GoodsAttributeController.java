package com.meituan.waimai.controller;

import com.meituan.waimai.common.model.entity.CommonPage;
import com.meituan.waimai.common.model.entity.CommonResult;
import com.meituan.waimai.model.GoodsAttribute;
import com.meituan.waimai.service.GoodsAttributeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "商品规格")
@RestController
@RequestMapping("/productAttr")
public class GoodsAttributeController {

    @Autowired
    private GoodsAttributeService attributeService;

    @ApiOperation("商品属性列表")
    @GetMapping("list")
    public CommonResult<CommonPage<GoodsAttribute>> list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                         @RequestParam Integer cateId) {
        List<GoodsAttribute> list = attributeService.list(pageNum, pageSize, cateId);
        return CommonResult.success(CommonPage.restPage(list));
    }


    @ApiOperation("创建商品属性")
    @PutMapping("/create")
    public CommonResult create(@RequestBody GoodsAttribute productAttribute) {
        return  attributeService.save(productAttribute)? CommonResult.success():CommonResult.failed();
    }

    @ApiOperation("修改商品属性")
    @PostMapping("/update")
    public CommonResult update(@RequestBody GoodsAttribute goodsAttribute) {
        return attributeService.updateById(goodsAttribute)? CommonResult.success():CommonResult.failed();
    }

}
