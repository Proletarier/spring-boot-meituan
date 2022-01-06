package com.meituan.waimai.consume.server;


public interface ConsumeCacheService {

	/**
	 * 获取用户缓存短信验证码
	 */
	String getCaptcha(String phone);

	/**
	 * 设置用户短信验证码
	 */

	void setCaptcha(String phone,String captcha);

	/**
	 * 获取今日验证发送次数
	 * @param phone
	 * @return
	 */
	Integer getSendCaptchaCount(String phone);

	/**
	 * 获取最后一次发送时间
	 * @return
	 */
	Long getSendCaptchaLastTime(String phone);


}
