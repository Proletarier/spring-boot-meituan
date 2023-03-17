package com.meituan.waimai.model.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CustomerLoginForm {

	@NotEmpty
	private String phone;

	@NotEmpty
	private String captcha;
}
