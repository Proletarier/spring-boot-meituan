package com.meituan.waimai.mall.controller;


import com.meituan.waimai.common.api.CommonResult;
import com.meituan.waimai.mall.dto.CustomerLoginForm;
import com.meituan.waimai.mall.server.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "后台用户管理")
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@ApiOperation(value = "登录以后返回token")
	@PostMapping(value = "/login")
	public CommonResult login(@Validated @RequestBody CustomerLoginForm customerLoginForm)  {
		String token = customerService.login(customerLoginForm);
		if (token == null) {
			return CommonResult.validateFailed("用户名或密码错误");
		}
		return CommonResult.success(token);
	}

	@ApiOperation(value = "登出")
	@PostMapping(value = "/logout")
	public CommonResult logout() {
		return CommonResult.success(null);
	}

	@ApiOperation(value = "获取短信验证码")
	@GetMapping(value = "/login")
	public CommonResult getCaptcha(@RequestParam("phone") String phone)  {
	    customerService.sendCaptcha(phone);
		return CommonResult.success();
	}
}
