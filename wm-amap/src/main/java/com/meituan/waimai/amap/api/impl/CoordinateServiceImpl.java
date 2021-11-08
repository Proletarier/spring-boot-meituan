package com.meituan.waimai.amap.api.impl;

import com.google.gson.JsonObject;
import com.meituan.waimai.amap.api.CoordinateService;
import com.meituan.waimai.amap.bean.Coordinate;
import com.meituan.waimai.common.exception.AMapErrorException;
import com.meituan.waimai.common.util.json.GsonHelper;
import org.springframework.stereotype.Service;

import static com.meituan.waimai.amap.enums.AMapUrl.Coordinate.COORDINATE_CONVERT;

@Service
public class CoordinateServiceImpl extends  AbstractAMapService implements CoordinateService {

	@Override
	public JsonObject convert(Coordinate coordinate) throws AMapErrorException {
		return get(COORDINATE_CONVERT.getUrl(), GsonHelper.ObjectToMapString(coordinate));
	}
}
