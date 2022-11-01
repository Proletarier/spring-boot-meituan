package com.meituan.waimai.consume.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.meituan.waimai.common.api.CommonResult;
import com.meituan.waimai.consume.model.dto.CustomerInfo;
import com.meituan.waimai.consume.model.dto.CustomerLoginForm;
import com.meituan.waimai.consume.server.CustomerService;
import com.meituan.waimai.model.Customer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "登录")
@RestController
public class LoginController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private CustomerService customerService;

	@ApiOperation(value = "登录")
	@PostMapping(value = "/login")
	public CommonResult<CustomerInfo> login(@Validated @RequestBody CustomerLoginForm customerLoginForm)  {
		LOGGER.info("loginForm={}",customerLoginForm);
		String token = customerService.login(customerLoginForm);
		if (token == null) {
			return CommonResult.validateFailed("用户名或密码错误");
		}
		CustomerInfo customerInfo = new CustomerInfo();
		Customer customer = customerService.getOne(new QueryWrapper<Customer>().lambda().eq(Customer::getPhone,customerLoginForm.getPhone()));
		customerInfo.setFace(customer.getFace());
		customerInfo.setId(customer.getId());
		customerInfo.setMember(customer.getIsMember() == 1);
		customerInfo.setToken(token);
		customerInfo.setName(customer.getCustomerName());
		return CommonResult.success(customerInfo);
	}

	@ApiOperation(value = "登出")
	@PostMapping(value = "/logout")
	public CommonResult<Void> logout() {
		return CommonResult.success(null);
	}

	@ApiOperation(value = "获取短信验证码")
	@GetMapping(value = "/captcha")
	public CommonResult<Void> getCaptcha(@RequestParam("phone") String phone)  {
		LOGGER.info("phone={}",phone);
		try {
			customerService.sendCaptcha(phone);
		}catch (Exception e){
			LOGGER.error("phone={}",phone);
			return CommonResult.serverFailed();
		}
		return CommonResult.success();
	}
}
