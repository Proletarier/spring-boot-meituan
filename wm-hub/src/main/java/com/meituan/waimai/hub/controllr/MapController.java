package com.meituan.waimai.hub.controllr;


import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.meituan.waimai.common.api.CommonResult;
import com.meituan.waimai.common.exception.AMapErrorException;
import com.meituan.waimai.common.util.IpUtils;
import com.meituan.waimai.common.util.RequestUtil;
import com.meituan.waimai.hub.api.map.*;
import com.meituan.waimai.hub.model.dto.map.*;
import com.meituan.waimai.hub.model.vo.MapAroundAddressInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api(tags = "地理位置服务")
@RestController
@RequestMapping("map")
public class MapController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MapController.class);

	@Autowired
	PoiSearchService poiSearchService;
	@Autowired
	IPLocationService ipLocationService;
	@Autowired
	DistrictService districtService;
	@Autowired
	CoordinateService coordinateService;
	@Autowired
	AssistantService assistantService;
	@Autowired
	HttpServletRequest request;

	@ApiOperation(value = "通过ip获取定位")
	@GetMapping(value = "/ip/location")
	public CommonResult<JsonObject> locationQuery(Location param)  {
		LOGGER.info("locationQuery={}",param);
		String requestIp = RequestUtil.getRequestIp(request);
		if(!IpUtils.internalIp(requestIp)){
			param.setIp(requestIp);
		}
		try {
			JsonObject jsonObject = ipLocationService.location(param);
			return CommonResult.success(jsonObject);
		} catch (AMapErrorException e) {
			LOGGER.error("locationQuery:/ip/location error:{}",e.getError());
			return CommonResult.failed();
		}
	}

	@ApiOperation(value = "根据关键字搜索地理位置信息")
	@GetMapping(value = "/poi/keyword")
	public CommonResult<JsonObject> keywordSearch(PoiSearch request)  {
		LOGGER.info("keywordSearch = {}",request);
		try {
			JsonObject 	jsonObject = poiSearchService.keywordSearch(request);
			return CommonResult.success(jsonObject);
		} catch (AMapErrorException e) {
			LOGGER.error("keywordSearch:/poi/keyword error:{}",e.getError());
			return CommonResult.failed();
		}
	}

	@ApiOperation(value = "根据定位搜索信息")
	@GetMapping(value = "/poi/around")
	public CommonResult<List<MapAroundAddressInfo>> aroundSearch(PoiSearch request)  {
		LOGGER.info("poiSearchQuery ={}",request);
		try {
			JsonObject jsonObject = poiSearchService.aroundSearch(request);
			JsonArray pois = jsonObject.getAsJsonArray("pois");
			List<MapAroundAddressInfo> aroundAddressInfos = Lists.newArrayList();
			if(pois != null && pois.size() >1 ){
				pois.forEach(item ->{
					MapAroundAddressInfo  addressInfo = new MapAroundAddressInfo();
					addressInfo.setAddress(item.getAsJsonObject().get("address").getAsString());
					addressInfo.setLocation(item.getAsJsonObject().get("location").getAsString());
					addressInfo.setName(item.getAsJsonObject().get("name").getAsString());
					aroundAddressInfos.add(addressInfo);
				});
			}
			return CommonResult.success(aroundAddressInfos);
		} catch (AMapErrorException e) {
			LOGGER.error("aroundSearch: error:{}",e.getError());
			return CommonResult.failed();
		}
	}

	@ApiOperation(value = "行政区域查询")
	@GetMapping(value = "/district")
	public CommonResult<JsonObject> districtSearch(District request)  {
		LOGGER.info("districtSearch={}",request);
		try {
			JsonObject jsonObject = districtService.districtSearch(request);
			return CommonResult.success(jsonObject);
		} catch (AMapErrorException e) {
			LOGGER.error("districtSearch: error:{}",e.getError());
			return CommonResult.failed();
		}
	}

	@ApiOperation(value = "坐标转换")
	@GetMapping(value = "/convert")
	public CommonResult<JsonObject> convert(Coordinate coordinate)  {
		LOGGER.info("coordinate={}",coordinate);
		JsonObject jsonObject = null;
		try {
			jsonObject = coordinateService.convert(coordinate);
			return 	CommonResult.success(jsonObject);
		} catch (AMapErrorException e) {
			LOGGER.error("coordinate: error:{}",e.getError());
			return CommonResult.failed();
		}
	}

	@ApiOperation(value = "输入提示")
	@GetMapping(value = "/assistant/input_tips")
	public CommonResult inputTips(InputTips inputTips)  {
		LOGGER.info("inputTips: {}",inputTips);
		try {
			JsonObject	jsonObject = assistantService.inputTips(inputTips);
			return CommonResult.success(jsonObject.toString());
		} catch (AMapErrorException e) {
			LOGGER.error("inputTips: error:{}",e.getError());
			return CommonResult.failed();
		}
	}
}
