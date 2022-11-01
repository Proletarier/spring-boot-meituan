package com.meituan.waimai.hub.api.map;

import com.google.gson.JsonObject;
import com.meituan.waimai.hub.model.dto.map.InputTips;
import com.meituan.waimai.common.exception.AMapErrorException;

public interface AssistantService {

	/**
	 * 输入提示
	 * @return
	 */
	JsonObject inputTips(InputTips inputTips) throws AMapErrorException;
}
