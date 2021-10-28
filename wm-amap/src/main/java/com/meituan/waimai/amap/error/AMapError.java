package com.meituan.waimai.amap.error;

import com.meituan.waimai.amap.util.json.GsonBuilder;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AMapError {

	/**
	 * 状态码
	 */
	private String errorCode;
	/**
	 * 错误消息
	 */
	private String errorMsg;

	private String json;


	public static AMapError fromJson(String json) {
		return GsonBuilder.create().fromJson(json, AMapError.class);
	}

	@Override
	public String toString() {
		if (this.json == null) {
			return "错误代码：" + this.errorCode + ", 错误信息：" + this.errorMsg;
		}
		return "错误代码：" + this.errorCode + ", 错误信息：" + this.errorMsg + "，原始报文：" + this.json;
	}
}
