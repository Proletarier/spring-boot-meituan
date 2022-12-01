package com.meituan.waimai.controller;

import com.meituan.waimai.common.model.entity.CommonPage;
import com.meituan.waimai.common.model.entity.CommonResult;
import com.meituan.waimai.dto.ShopInfo;
import com.meituan.waimai.model.Shop;
import com.meituan.waimai.service.ShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "商家管理")
@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;


    @ApiOperation("创建商家")
    @PutMapping("/create")
    public CommonResult createShop(@RequestBody ShopInfo shop) {
        int count = shopService.createShop(shop);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("更新商家信息")
    @PostMapping("/update")
    public CommonResult updateShop(@RequestBody ShopInfo shopInfo) {
       return CommonResult.success();
    }


    @GetMapping("/list")
    public CommonResult<CommonPage<Shop>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                               @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {

        List<Shop> shops = shopService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(shops));
    }


    @ApiOperation("根据id查询商家详情")
    @GetMapping("/{shopId}")
    public CommonResult<ShopInfo> getShopInfo(@PathVariable Integer shopId) {
        ShopInfo shopInfo = shopService.getShopInById(shopId);
        return CommonResult.success(shopInfo);
    }


}
