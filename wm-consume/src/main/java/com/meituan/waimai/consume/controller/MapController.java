package com.meituan.waimai.consume.controller;


import com.google.gson.JsonObject;
import com.meituan.waimai.amap.bean.*;
import com.meituan.waimai.common.api.CommonResult;
import com.meituan.waimai.consume.server.MapService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "地理位置服务")
@RestController("/business/map")
public class MapController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MapController.class);

	@Autowired
	MapService mapService;

	@ApiOperation(value = "通过ip获取定位")
	@GetMapping(value = "/ip/location")
	public CommonResult getCaptcha(Location request)  {
		LOGGER.info("locationQuery={}",request);
		JsonObject jsonObject = mapService.location(request);
		if (jsonObject == null){
			return CommonResult.failed();
		}
		return CommonResult.success(jsonObject.toString());
	}

	@ApiOperation(value = "根据关键字搜索地理位置信息")
	@GetMapping(value = "/poi/keyword")
	public CommonResult keywordSearch(PoiSearch request)  {
		LOGGER.info("poiSearchQuery = {}",request);
		JsonObject jsonObject = mapService.keywordSearch(request);
		if (jsonObject == null){
			return CommonResult.failed();
		}
		return CommonResult.success(jsonObject.toString());
	}

	@ApiOperation(value = "根据定位搜索信息")
	@GetMapping(value = "/poi/around")
	public CommonResult aroundSearch(PoiSearch request)  {
		LOGGER.info("poiSearchQuery ={ }",request);
		JsonObject jsonObject = mapService.aroundSearch(request);
		if (jsonObject == null){
			return CommonResult.failed();
		}
		return CommonResult.success(jsonObject.toString());
	}

	@ApiOperation(value = "行政区域查询")
	@GetMapping(value = "/district")
	public CommonResult districtSearch(District request)  {
		LOGGER.info("districtQuery={}",request);
		JsonObject jsonObject = mapService.districtSearch(request);
		if (jsonObject == null){
			return CommonResult.failed();
		}
		return CommonResult.success(jsonObject.toString());
	}

	@ApiOperation(value = "坐标转换")
	@GetMapping(value = "/convert")
	public CommonResult convert(Coordinate coordinate)  {
		LOGGER.info("coordinate={}",coordinate);
		JsonObject jsonObject = mapService.convert(coordinate);
		if (jsonObject == null){
			return CommonResult.failed();
		}
		return CommonResult.success(jsonObject.toString());
	}

	@ApiOperation(value = "输入提示")
	@GetMapping(value = "/assistant/input_tips")
	public CommonResult inputTips(InputTips inputTips)  {
		LOGGER.info("inputTips={}",inputTips);
		JsonObject jsonObject = mapService.inputTips(inputTips);
		if (jsonObject == null){
			return CommonResult.failed();
		}
		return CommonResult.success(jsonObject.toString());
	}
}
