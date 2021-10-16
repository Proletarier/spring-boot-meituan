package com.meituan.waimai.business.server.impl;


import cn.hutool.core.util.StrUtil;
import com.meituan.waimai.common.exception.ApiException;
import com.meituan.waimai.common.util.DateUtil;
import com.meituan.waimai.business.dto.form.CustomerLoginForm;
import com.meituan.waimai.business.server.CustomerService;
import com.meituan.waimai.business.server.BusinessCacheService;
import com.meituan.waimai.po.Customer;
import com.meituan.waimai.repository.CustomerAddressRepository;
import com.meituan.waimai.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	CustomerAddressRepository addressRepository;
	@Autowired
	BusinessCacheService mallCacheService;

	@Override
	public String login(CustomerLoginForm loginForm) {
	 String captchaCode = mallCacheService.getCaptcha(loginForm.getPhone());

	 if (!loginForm.getCaptcha().equals(captchaCode)){
		 throw  new ApiException("验证码验证失败");
	 }
	 Customer customer = customerRepository.findByPhone(loginForm.getPhone());
	 if (Objects.isNull(customer)){
	 	customer = new Customer();
	 	customer.setPhone(loginForm.getPhone());
	 	customer.setStatus(1);
	 	customer.setCustomerName(loginForm.getPhone());
	 	customerRepository.save(customer);
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
