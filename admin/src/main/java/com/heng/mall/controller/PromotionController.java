package com.heng.mall.controller;

import com.heng.mall.common.api.CommonResult;
import com.heng.mall.model.Promotion;
import com.heng.mall.service.PromotionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = "推广")
@RestController
@RequestMapping("/promotion")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @ApiOperation("推广列表")
    @GetMapping("/list")
    public CommonResult<List<Promotion>> listPromotion(@RequestParam("promotionType") Integer promotionType) {
        List<Promotion> list = promotionService.listPromotion(promotionType);
        return CommonResult.success(list);
    }
}
