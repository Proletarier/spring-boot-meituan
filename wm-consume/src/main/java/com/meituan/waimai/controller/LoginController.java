package com.meituan.waimai.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.meituan.waimai.common.domain.CommonResult;
import com.meituan.waimai.common.exception.ApiException;
import com.meituan.waimai.model.dto.CustomerInfo;
import com.meituan.waimai.model.dto.CustomerLoginForm;
import com.meituan.waimai.server.CustomerService;
import com.meituan.waimai.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private CustomerService customerService;

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

	@PostMapping(value = "/logout")
	public CommonResult<Void> logout() {
		return CommonResult.success(null);
	}

	@GetMapping(value = "/captcha")
	public CommonResult<Void> getCaptcha(@RequestParam("phone") String phone)  {
		LOGGER.info("phone={}",phone);
		try {
			customerService.sendCaptcha(phone);
		}catch (ApiException e){
			LOGGER.error("phone={}:{}",phone,e);
			return CommonResult.failed(e.getMessage());
		}catch (Exception e){
			LOGGER.error("phone={}:{}",phone,e);
			return CommonResult.serverFailed();
		}
		return CommonResult.success();
	}
}
