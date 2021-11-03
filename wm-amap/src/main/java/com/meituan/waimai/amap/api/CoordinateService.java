package com.meituan.waimai.amap.api;

import com.google.gson.JsonObject;
import com.meituan.waimai.amap.bean.Coordinate;
import com.meituan.waimai.amap.error.AMapErrorException;

public interface CoordinateService {

	JsonObject convert(Coordinate coordinate) throws Exception;
}
