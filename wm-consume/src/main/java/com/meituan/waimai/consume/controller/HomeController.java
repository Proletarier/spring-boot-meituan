package com.meituan.waimai.consume.controller;

import com.meituan.waimai.common.api.CommonResult;
import com.meituan.waimai.consume.model.vo.GoodsCategoryVo;
import com.meituan.waimai.consume.server.HomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "首页")
@Slf4j
@RestController
@RequestMapping("/home")
public class HomeController {

	@Autowired
	HomeService homeService;

	@ApiOperation(value = "获取当前登录用户的地址列表")
	@GetMapping(value = "/list/goods_menu")
	public CommonResult<List<GoodsCategoryVo>> listGoodsMenu(){
		return  CommonResult.success(homeService.listGoodsCategory());
	}


}
