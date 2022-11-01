package com.meituan.waimai.hub.api.map;

import com.google.gson.JsonObject;
import com.meituan.waimai.hub.model.dto.map.Coordinate;
import com.meituan.waimai.common.exception.AMapErrorException;

public interface CoordinateService {

	JsonObject convert(Coordinate coordinate)  throws AMapErrorException;
}
