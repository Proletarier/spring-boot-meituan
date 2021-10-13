package com.meituan.waimai.mall.server.impl;


import com.meituan.waimai.mall.dto.CustomerLoginForm;
import com.meituan.waimai.mall.server.CustomerService;
import com.meituan.waimai.mall.server.MallCacheService;
import com.meituan.waimai.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private MallCacheService mallCacheService;

	@Override
	public String login(CustomerLoginForm customerLoginForm) {
		return null;
	}

	@Override
	public void sendCaptcha(String phone) {
		//TODO 验证码需要接入短信平台，暂时设置123456
		String captcha = "123456";
		mallCacheService.setCaptcha(phone,captcha);
	}
}
