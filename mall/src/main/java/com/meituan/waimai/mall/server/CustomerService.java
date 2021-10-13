package com.meituan.waimai.mall.server;

import com.meituan.waimai.mall.dto.CustomerLoginForm;

public interface CustomerService {

	String login(CustomerLoginForm customerLoginForm);

	void sendCaptcha(String phone);
}
