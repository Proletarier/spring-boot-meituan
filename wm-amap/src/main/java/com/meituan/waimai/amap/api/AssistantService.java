package com.meituan.waimai.amap.api;

import com.google.gson.JsonObject;
import com.meituan.waimai.amap.bean.InputTips;
import com.meituan.waimai.common.exception.AMapErrorException;

public interface AssistantService {

	/**
	 * 输入提示
	 * @return
	 */
	JsonObject inputTips(InputTips inputTips) throws AMapErrorException;
}
