package com.meituan.waimai.hub.api.map.impl;

import com.google.gson.JsonObject;
import com.meituan.waimai.hub.api.map.AssistantService;
import com.meituan.waimai.hub.model.dto.map.InputTips;
import com.meituan.waimai.common.exception.AMapErrorException;
import com.meituan.waimai.common.util.json.GsonHelper;
import org.springframework.stereotype.Service;
import static com.meituan.waimai.hub.enums.AMapUrl.Assistant.ASSISTANT_INPUT_TIPS;


@Service
public class AssistantServiceImpl extends AbstractAMapService implements AssistantService {

	@Override
	public JsonObject inputTips(InputTips inputTips) throws AMapErrorException {
		return  get(ASSISTANT_INPUT_TIPS.getUrl(), GsonHelper.ObjectToMapString(inputTips));
	}
}
