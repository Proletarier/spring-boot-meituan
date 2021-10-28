package com.meituan.waimai.business.server;

import com.google.gson.JsonObject;
import com.meituan.waimai.amap.bean.LocationRequest;

public interface MapService {

	JsonObject location(LocationRequest param);
}
