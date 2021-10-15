package com.meituan.waimai.mall.dto.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CustomerLoginForm {

	@NotEmpty
	@ApiModelProperty(value = "电话号码", required = true)
	private String phone;

	@NotEmpty
	@ApiModelProperty(value = "短信验证码", required = true)
	private String captcha;
}
