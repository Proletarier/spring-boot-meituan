package com.heng.mall.controller;

import com.heng.mall.common.api.CommonResult;
import com.heng.mall.dto.RegionWithChildrenItem;
import com.heng.mall.service.RegionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "市区")
@RestController
@RequestMapping("/region")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping("/listChildren")
    public CommonResult<List<RegionWithChildrenItem>> listWithChildren() {
        List<RegionWithChildrenItem> list = regionService.listWithChildren();
        return CommonResult.success(list);
    }

}
