package com.meituan.waimai.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.meituan.waimai.common.domain.CommonResult;
import com.meituan.waimai.mapper.ShopLicenseMapper;
import com.meituan.waimai.model.ShopLicense;
import com.meituan.waimai.model.vo.CommentDetail;
import com.meituan.waimai.model.vo.FoodCategory;
import com.meituan.waimai.model.vo.ShopComment;
import com.meituan.waimai.model.vo.ShopInfo;
import com.meituan.waimai.server.ShopServer;
import com.meituan.waimai.validation.shop.ValidExistShop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/shop")
public class ShopController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShopController.class);

    @Autowired
    private  ShopServer shopServer;
    @Autowired
    private ShopLicenseMapper shopLicenseMapper;

    @GetMapping(value = "/{shopId}")
    public CommonResult<ShopInfo> getShopInfo(@PathVariable("shopId") @ValidExistShop Integer shopId) {
        return CommonResult.success(shopServer.getShopInfo(shopId));
    }

    @GetMapping(value = "/qualification/{shopId}")
    public CommonResult<ShopLicense> getShopQualification(@PathVariable("shopId") @ValidExistShop Integer shopId) {
        LambdaQueryWrapper<ShopLicense> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(ShopLicense::getShopId,shopId);
        return CommonResult.success(shopLicenseMapper.selectOne(queryWrapper));
    }

    @GetMapping(value = "/getFood/{shopId}")
    public CommonResult<List<FoodCategory>> getFood(@PathVariable("shopId") @ValidExistShop Integer shopId) {
        List<FoodCategory> categoryList = shopServer.getFood(shopId);
        return CommonResult.success(categoryList);
    }

    @GetMapping(value = "/commentsSummary/{shopId}")
    public CommonResult<ShopComment> commentsSummary(@PathVariable("shopId") @ValidExistShop Integer shopId) {
        return CommonResult.success(shopServer.getShopComment(shopId));
    }

    @GetMapping(value = "/getCommentList")
    public CommonResult<List<CommentDetail>> getCommentList(@RequestParam("shopId") @ValidExistShop Integer shopId,
                                                            @RequestParam("commentLabelId") Integer commentLabelId,
                                                            @RequestParam("pageNum") Integer pageNum,
                                                            @RequestParam("pageSize") Integer pageSize) {
        return CommonResult.success(shopServer.getCommentList(shopId,commentLabelId,pageNum,pageSize));
    }
}
