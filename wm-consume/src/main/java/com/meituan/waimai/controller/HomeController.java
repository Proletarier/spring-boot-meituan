package com.meituan.waimai.controller;

import com.meituan.waimai.bean.GeoPoint;
import com.meituan.waimai.common.domain.CommonResult;
import com.meituan.waimai.model.dto.ShopFilter;
import com.meituan.waimai.model.vo.FoodMenu;
import com.meituan.waimai.model.vo.NearShops;
import com.meituan.waimai.server.HomeServer;
import com.meituan.waimai.server.ShopServer;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "首页")
@Slf4j
@RestController
@RequestMapping("/api/home")
public class HomeController {

    @Autowired
    ShopServer shopServer;
    @Autowired
    HomeServer homeServer;


    @GetMapping(value = "/goods_cate")
    public CommonResult<List<FoodMenu>> listGoodsCate() {
        return CommonResult.success(homeServer.getFoodMenu());
    }

    @GetMapping(value = "/filter_conditions")
    public CommonResult<Object> filterConditions() {
        return CommonResult.success(homeServer.getFilterConditions());
    }

    @GetMapping(value = "/categoriesByChildren")
    public CommonResult<Object> categoriesByChildren() {
        return CommonResult.success(homeServer.categoriesByChildren());
    }


    @PostMapping(value = "/getShops")
    public CommonResult<NearShops> getShops(@RequestBody ShopFilter shopFilter) {
        GeoPoint geoPoint = shopFilter.getLocation();
        if (geoPoint == null || geoPoint.getLat() == null || geoPoint.getLng() == null) {
            return CommonResult.success(NearShops.builder().count(0).shopVoList(new ArrayList<>(0)).build());
        }
        NearShops shops = shopServer.getNearShop(shopFilter);
        log.info("SUCCESS|getShops|{}|{}", null, null);
        return CommonResult.success(shops);
    }
}
