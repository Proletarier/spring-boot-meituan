package com.meituan.waimai.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AdminLoginParam {

    @NotEmpty
    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    @NotEmpty
    @ApiModelProperty(value = "密码", required = true)
    private String password;
}
