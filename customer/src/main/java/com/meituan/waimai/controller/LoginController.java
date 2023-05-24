package com.meituan.waimai.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.meituan.waimai.bean.CustomerContext;
import com.meituan.waimai.common.domain.CommonResult;

import com.meituan.waimai.common.util.JwtTokenUtil;
import com.meituan.waimai.enums.CustomerEnum;
import com.meituan.waimai.model.dto.CustomerInfo;
import com.meituan.waimai.model.dto.CustomerLoginForm;
import com.meituan.waimai.server.ConsumeCacheService;
import com.meituan.waimai.server.CustomerService;
import com.meituan.waimai.model.Customer;
import com.meituan.waimai.validation.captcha.OverSendCaptcha;
import com.meituan.waimai.validation.captcha.ValidCaptcha;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@Validated
@RestController
@RequestMapping("/api")
public class LoginController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	CustomerService customerService;
	@Autowired
	ConsumeCacheService cacheService;
	@Autowired
	JwtTokenUtil jwtTokenUtil;

	@PostMapping(value = "/login")
	public CommonResult<CustomerInfo> login(@ValidCaptcha @RequestBody CustomerLoginForm loginForm)  {
		LOGGER.info("loginForm={}",loginForm);
		Customer customer = customerService.getOne(new QueryWrapper<Customer>().lambda().eq(Customer::getPhone,loginForm.getPhone()));
		if (Objects.isNull(customer)){
			customer = new Customer();
			customer.setPhone(loginForm.getPhone());
			customer.setStatus(CustomerEnum.valid);
			customer.setIsMember(Boolean.FALSE);
			customer.setCustomerName(loginForm.getPhone());
			customerService.save(customer);
		}
		String token = createToken(customer);
		if (token == null) {
			return CommonResult.validateFailed("用户名或密码错误");
		}
		CustomerInfo customerInfo = new CustomerInfo();
		customerInfo.setFace(customer.getFace());
		customerInfo.setId(customer.getId());
		customerInfo.setMember(customer.getIsMember());
		customerInfo.setToken(token);
		customerInfo.setName(customer.getCustomerName());
		LOGGER.info("SUCCESS|login|{}", customerInfo);

		return CommonResult.success(customerInfo);
	}

	@PostMapping(value = "/logout")
	public CommonResult<Void> logout() {
		return CommonResult.success(null);
	}

	@GetMapping(value = "/captcha")
	public CommonResult<Void> getCaptcha(@OverSendCaptcha String phone)  {
		LOGGER.debug("getCaptcha|phone={}",phone);
		//TODO 验证码需要接入短信平台，暂时设置123456
		String captcha = "123456";
		try {
			cacheService.setCaptcha(phone,captcha);
		}catch (Exception e){
			LOGGER.error("getCaptcha|send failed",e);
			return CommonResult.serverFailed();
		}
		LOGGER.info("SUCCESS|getCaptcha|{}", CustomerContext.getCustomerId());
		return CommonResult.success();
	}

	private String createToken(Customer customer){
		Map<String, Object> claims =new HashMap<>();
		claims.put("customerId",customer.getId());
		claims.put("phone",customer.getPhone());
		return jwtTokenUtil.generateToken(claims);
	}
}
