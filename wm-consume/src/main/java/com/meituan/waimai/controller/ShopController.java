package com.meituan.waimai.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.meituan.waimai.common.domain.CommonResult;
import com.meituan.waimai.mapper.ShopLicenseMapper;
import com.meituan.waimai.model.Discount;
import com.meituan.waimai.model.ShopLicense;
import com.meituan.waimai.model.vo.ShopInfo;
import com.meituan.waimai.server.ShopServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/shop")
public class ShopController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShopController.class);

    @Autowired
    private  ShopServer shopServer;

    @Autowired
    private ShopLicenseMapper shopLicenseMapper;

    @GetMapping(value = "/{shopId}")
    public CommonResult<ShopInfo> getShopInfo(@PathVariable("shopId") Integer shopId) {
        return CommonResult.success(shopServer.getShopInfo(shopId));
    }

    @GetMapping(value = "/qualification/{shopId}")
    public CommonResult<ShopLicense> getShopQualification(@PathVariable("shopId") Integer shopId) {
        LambdaQueryWrapper<ShopLicense> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(ShopLicense::getShopId,shopId);
        return CommonResult.success(shopLicenseMapper.selectOne(queryWrapper));
    }
}
