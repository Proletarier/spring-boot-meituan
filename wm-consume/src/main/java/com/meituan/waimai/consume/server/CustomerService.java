package com.meituan.waimai.consume.server;

import com.baomidou.mybatisplus.extension.service.IService;
import com.meituan.waimai.consume.model.dto.CustomerLoginForm;
import com.meituan.waimai.model.Customer;

public interface CustomerService extends IService<Customer> {

	String login(CustomerLoginForm customerLoginForm);

	void sendCaptcha(String phone);

}
