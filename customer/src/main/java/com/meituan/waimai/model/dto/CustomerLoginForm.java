package com.meituan.waimai.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CustomerLoginForm {

    @NotBlank(message = "Param 'phone' can't be blank")
    @Size(max = 11,message = "Param 'phone' must be less than 11 characters.")
    private String phone;

    @NotBlank(message = "Param 'captcha' can't be blank")
    @Size(max = 6,message = "Param 'phone' must be less than 6 characters.")
    private String captcha;
}
