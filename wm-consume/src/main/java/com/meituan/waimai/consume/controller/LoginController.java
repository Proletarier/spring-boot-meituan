package com.meituan.waimai.consume.controller;


import com.meituan.waimai.common.api.CommonResult;
import com.meituan.waimai.consume.model.dto.CustomerLoginForm;
import com.meituan.waimai.consume.server.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "登录")
@RestController("/")
public class LoginController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private CustomerService customerService;

	@ApiOperation(value = "登录以后返回token")
	@PostMapping(value = "login")
	public CommonResult login(@Validated @RequestBody CustomerLoginForm customerLoginForm)  {
		LOGGER.info("loginForm={}",customerLoginForm);
		String token = customerService.login(customerLoginForm);
		if (token == null) {
			return CommonResult.validateFailed("用户名或密码错误");
		}
		return CommonResult.success(token);
	}

	@ApiOperation(value = "登出")
	@PostMapping(value = "logout")
	public CommonResult logout() {
		return CommonResult.success(null);
	}

	@ApiOperation(value = "获取短信验证码")
	@GetMapping(value = "captcha")
	public CommonResult getCaptcha(@RequestParam("phone") String phone)  {
		LOGGER.info("phone={}",phone);
	    customerService.sendCaptcha(phone);
		return CommonResult.success();
	}
}
