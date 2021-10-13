package com.meituan.waimai.mall.server;


public interface MallCacheService {

	/**
	 * 获取用户缓存短信验证码
	 */
	String getCaptcha(String phone);

	/**
	 * 设置用户短信验证码
	 */

	void setCaptcha(String phone,String captcha);
}
