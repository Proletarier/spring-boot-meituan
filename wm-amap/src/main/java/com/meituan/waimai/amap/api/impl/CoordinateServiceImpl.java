package com.meituan.waimai.amap.api.impl;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.meituan.waimai.amap.api.AMapService;
import com.meituan.waimai.amap.api.CoordinateService;
import com.meituan.waimai.amap.bean.Coordinate;
import com.meituan.waimai.amap.error.AMapError;
import com.meituan.waimai.amap.error.AMapErrorException;
import com.meituan.waimai.common.util.json.GsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.meituan.waimai.amap.enums.AMapUrl.Coordinate.COORDINATE_CONVERT;

@Service
public class CoordinateServiceImpl implements CoordinateService {

	@Autowired
	private AMapService aMapService;

	@Override
	public JsonObject convert(Coordinate coordinate) throws Exception {
		String json = aMapService.get(COORDINATE_CONVERT.getUrl(), GsonHelper.ObjectToMapString(coordinate));
		JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
		if (!"1".equals(jsonObject.get("status").getAsString())) {
			throw new AMapErrorException(AMapError.fromJson(json));
		}
		return jsonObject;
	}
}
