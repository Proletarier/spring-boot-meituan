package com.meituan.waimai.business.controller;


import com.google.gson.JsonObject;
import com.meituan.waimai.amap.bean.LocationRequest;
import com.meituan.waimai.business.server.MapService;
import com.meituan.waimai.common.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "地理位置服务")
@RestController
@RequestMapping("/business/map/")
public class MapController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	MapService mapService;

	@ApiOperation(value = "通过ip获取定位")
	@GetMapping(value = "ip/location")
	public CommonResult getCaptcha(LocationRequest request)  {
		LOGGER.info("LocationRequest={}",request);
		JsonObject jsonObject = mapService.location(request);
		if (jsonObject == null){
			return CommonResult.failed();
		}
		return CommonResult.success(jsonObject.toString());
	}
}
