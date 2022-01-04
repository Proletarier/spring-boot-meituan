package com.meituan.waimai.business.server;

import com.meituan.waimai.business.model.dto.CustomerLoginForm;

public interface CustomerService {

	String login(CustomerLoginForm customerLoginForm);

	void sendCaptcha(String phone);

}
