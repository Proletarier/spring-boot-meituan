package com.meituan.waimai.business.server.impl;


import cn.hutool.core.util.StrUtil;
import com.meituan.waimai.common.exception.Asserts;
import com.meituan.waimai.common.util.DateUtil;
import com.meituan.waimai.business.model.dto.CustomerLoginForm;
import com.meituan.waimai.business.server.CustomerService;
import com.meituan.waimai.business.server.BusinessCacheService;
import com.meituan.waimai.common.util.JwtTokenUtil;
import com.meituan.waimai.po.Customer;
import com.meituan.waimai.repository.CustomerAddressRepository;
import com.meituan.waimai.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	CustomerAddressRepository addressRepository;
	@Autowired
	BusinessCacheService mallCacheService;
	@Autowired
	JwtTokenUtil jwtTokenUtil;

	@Override
	public String login(CustomerLoginForm loginForm) {
	 String captchaCode = mallCacheService.getCaptcha(loginForm.getPhone());
	 if (StrUtil.isBlank(loginForm.getCaptcha()) || !loginForm.getCaptcha().equals(captchaCode)){
		 Asserts.fail("验证码验证失败");
	 }
	 Customer customer = customerRepository.findByPhone(loginForm.getPhone());
	 if (Objects.isNull(customer)){
	 	customer = new Customer();
	 	customer.setPhone(loginForm.getPhone());
	 	customer.setStatus(1);
	 	customer.setCustomerName(loginForm.getPhone());
	 	customerRepository.save(customer);
	 }
	 return createToken(customer);
	}

	@Override
	public void sendCaptcha(String phone) {
		String value = mallCacheService.getCaptcha(phone);
		if (!StrUtil.isBlank(value)){
			int count = mallCacheService.getSendCaptchaCount(phone);
			if (count >= 5){
				Asserts.fail("当日发送验证码达到上限");
			}
			long lastTime = mallCacheService.getSendCaptchaLastTime(phone);
			if (DateUtil.getCurrentSeconds() - lastTime < 100){
				Asserts.fail("频繁操作");
			}
		}
		//TODO 验证码需要接入短信平台，暂时设置123456
		String captcha = "123456";
		mallCacheService.setCaptcha(phone,captcha);
	}

	private String createToken(Customer customer){
		Map<String, Object> claims =new HashMap<>();
		claims.put("customerId",customer.getId());
		claims.put("phone",customer.getPhone());
		return jwtTokenUtil.generateToken(claims);
	}
}
