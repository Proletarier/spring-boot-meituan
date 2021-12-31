package com.meituan.waimai.amap.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "amap")
@Component
public class BaseKey {

	/**
	 * 请求服务权限标识
	 */
	private String key;
}
