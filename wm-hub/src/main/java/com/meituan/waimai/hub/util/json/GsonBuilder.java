package com.meituan.waimai.hub.util.json;

import com.google.gson.Gson;
import com.meituan.waimai.common.error.AMapError;

public class GsonBuilder {

	private static final com.google.gson.GsonBuilder INSTANCE = new com.google.gson.GsonBuilder();

	static {
		INSTANCE.disableHtmlEscaping();
		INSTANCE.registerTypeAdapter(AMapError.class, new AMapErrorAdapter());
	}

	public static Gson create() {
		return INSTANCE.create();
	}
}
