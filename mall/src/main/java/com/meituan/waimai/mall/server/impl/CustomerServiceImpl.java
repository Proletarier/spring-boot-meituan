package com.meituan.waimai.mall.server.impl;


import cn.hutool.core.util.StrUtil;
import com.meituan.waimai.common.exception.ApiException;
import com.meituan.waimai.common.util.DateUtil;
import com.meituan.waimai.mall.dto.CustomerLoginForm;
import com.meituan.waimai.mall.server.CustomerService;
import com.meituan.waimai.mall.server.MallCacheService;
import com.meituan.waimai.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private MallCacheService mallCacheService;

	@Override
	public String login(CustomerLoginForm loginForm) {
	 String captchaCode = mallCacheService.getCaptcha(loginForm.getPhone());

	 if (!loginForm.getCaptcha().equals(captchaCode)){
		 throw  new ApiException("验证码验证失败");
	 }

	 return null;
	}

	@Override
	public void sendCaptcha(String phone) {

		String value = mallCacheService.getCaptcha(phone);
		if (!StrUtil.isBlank(value)){
			int count = mallCacheService.getSendCaptchaCount(phone);
			if (count >= 5){
				throw  new ApiException("当日发送验证码次数达到上限");
			}
			long lastTime = mallCacheService.getSendCaptchaLastTime(phone);
			if (DateUtil.getCurrentSeconds() - lastTime < 100){
				throw  new ApiException("验证码发送太频繁");
			}
		}
		//TODO 验证码需要接入短信平台，暂时设置123456
		String captcha = "123456";
		mallCacheService.setCaptcha(phone,captcha);
	}
}
