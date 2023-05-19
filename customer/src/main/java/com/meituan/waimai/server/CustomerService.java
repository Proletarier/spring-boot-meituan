package com.meituan.waimai.server;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.meituan.waimai.common.exception.Asserts;
import com.meituan.waimai.common.util.DateUtil;
import com.meituan.waimai.common.util.JwtTokenUtil;
import com.meituan.waimai.model.dto.CustomerLoginForm;
import com.meituan.waimai.enums.CustomerEnum;
import com.meituan.waimai.mapper.CustomerAddressMapper;
import com.meituan.waimai.mapper.CustomerMapper;
import com.meituan.waimai.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class CustomerService extends ServiceImpl<CustomerMapper, Customer>   {

	@Autowired
	CustomerAddressMapper addressRepository;
	@Autowired
	ConsumeCacheService cacheService;
	@Autowired
	JwtTokenUtil jwtTokenUtil;


	public String login(CustomerLoginForm loginForm) {
	 String captchaCode = cacheService.getCaptcha(loginForm.getPhone());
	 if (StrUtil.isBlank(loginForm.getCaptcha()) || !loginForm.getCaptcha().equals(captchaCode)){
		 Asserts.fail("验证码验证失败");
	 }
	 Customer customer = getOne(new QueryWrapper<Customer>().lambda().eq(Customer::getPhone,loginForm.getPhone()));
	 if (Objects.isNull(customer)){
	 	customer = new Customer();
	 	customer.setPhone(loginForm.getPhone());
	 	customer.setStatus(CustomerEnum.valid);
	 	customer.setIsMember(CustomerEnum.no_member);
	 	customer.setCustomerName(loginForm.getPhone());
	 	save(customer);
	 }
	 return createToken(customer);
	}

	public void sendCaptcha(String phone) {
		String value = cacheService.getCaptcha(phone);
		if (!StrUtil.isBlank(value)){
			int count = cacheService.getSendCaptchaCount(phone);
			if (count >= 5){
				Asserts.fail("当日发送验证码达到上限");
			}
			long lastTime = cacheService.getSendCaptchaLastTime(phone);
			if (DateUtil.getCurrentSeconds() - lastTime < 100){
				Asserts.fail("频繁操作");
			}
		}
		//TODO 验证码需要接入短信平台，暂时设置123456
		String captcha = "123456";
		cacheService.setCaptcha(phone,captcha);
	}

	private String createToken(Customer customer){
		Map<String, Object> claims =new HashMap<>();
		claims.put("customerId",customer.getId());
		claims.put("phone",customer.getPhone());
		return jwtTokenUtil.generateToken(claims);
	}
}
