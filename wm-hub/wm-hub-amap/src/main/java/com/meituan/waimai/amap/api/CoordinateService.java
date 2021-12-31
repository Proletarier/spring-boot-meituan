package com.meituan.waimai.amap.api;

import com.google.gson.JsonObject;
import com.meituan.waimai.amap.bean.Coordinate;
import com.meituan.waimai.common.exception.AMapErrorException;

public interface CoordinateService {

	JsonObject convert(Coordinate coordinate)  throws AMapErrorException;
}
