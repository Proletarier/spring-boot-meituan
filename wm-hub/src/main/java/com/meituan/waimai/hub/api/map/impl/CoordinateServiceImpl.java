package com.meituan.waimai.hub.api.map.impl;

import com.google.gson.JsonObject;
import com.meituan.waimai.hub.api.map.CoordinateService;
import com.meituan.waimai.hub.model.dto.map.Coordinate;
import com.meituan.waimai.common.exception.AMapErrorException;
import com.meituan.waimai.common.util.json.GsonHelper;
import org.springframework.stereotype.Service;

import static com.meituan.waimai.hub.enums.AMapUrl.Coordinate.COORDINATE_CONVERT;

@Service
public class CoordinateServiceImpl extends AbstractAMapService implements CoordinateService {

	@Override
	public JsonObject convert(Coordinate coordinate) throws AMapErrorException {
		return get(COORDINATE_CONVERT.getUrl(), GsonHelper.ObjectToMapString(coordinate));
	}
}
