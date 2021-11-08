package com.meituan.waimai.common.util.json;

import com.google.gson.*;
import com.meituan.waimai.common.error.AMapError;

import java.lang.reflect.Type;

public class AMapErrorAdapter  implements JsonDeserializer<AMapError> {

	@Override
	public AMapError deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
		AMapError.AMapErrorBuilder errorBuilder = AMapError.builder();
		JsonObject errorJsonObject = json.getAsJsonObject();

		if (errorJsonObject.get("infocode") != null && !errorJsonObject.get("infocode").isJsonNull()) {
			errorBuilder.errorCode(errorJsonObject.get("infocode").getAsString());
		}
		if (errorJsonObject.get("info") != null && !errorJsonObject.get("info").isJsonNull()) {
			errorBuilder.errorMsg(errorJsonObject.get("info").getAsString());
		}
		errorBuilder.json(json.toString());
		return errorBuilder.build();
	}
}
