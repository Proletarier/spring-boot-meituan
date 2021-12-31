package com.meituan.waimai.amap.api.impl;

import com.google.gson.JsonObject;
import com.meituan.waimai.amap.api.IPLocationService;
import com.meituan.waimai.amap.bean.Location;
import com.meituan.waimai.common.exception.AMapErrorException;
import com.meituan.waimai.common.util.json.GsonHelper;
import org.springframework.stereotype.Service;


import static com.meituan.waimai.amap.enums.AMapUrl.IP.*;

@Service
public class IPLocationServiceImpl extends AbstractAMapService implements IPLocationService {

	@Override
	public JsonObject location(Location param) throws AMapErrorException {
		return get(IP_LOCATION.getUrl(),GsonHelper.ObjectToMapString(param));
	}
}
