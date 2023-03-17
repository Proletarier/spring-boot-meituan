package com.meituan.waimai.common.service.map;

import com.google.gson.JsonObject;
import com.meituan.waimai.common.exception.AMapErrorException;
import com.meituan.waimai.common.model.map.InputTips;
import com.meituan.waimai.common.util.json.GsonHelper;
import org.springframework.stereotype.Service;
import static com.meituan.waimai.common.model.enums.AMapUrl.Assistant.ASSISTANT_INPUT_TIPS;



@Service
public class AssistantService extends AbstractAMapService   {


	public JsonObject inputTips(InputTips inputTips) throws AMapErrorException {
		return  get(ASSISTANT_INPUT_TIPS.getUrl(), GsonHelper.ObjectToMapString(inputTips));
	}
}
