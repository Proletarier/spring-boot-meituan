package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="com-meituan-waimai-model-AdminUser")
@Data
@TableName(value = "wm_admin_user")
public class AdminUser extends BaseEntity {

    @TableField(value = "username")
    @ApiModelProperty(value="")
    private String username;

    @TableField(value = "password")
    @ApiModelProperty(value="")
    private String password;

    @TableField(value = "email")
    @ApiModelProperty(value="")
    private String email;

    @TableField(value = "nick_name")
    @ApiModelProperty(value="")
    private String nickName;

    @TableField(value = "note")
    @ApiModelProperty(value="")
    private String note;

    @TableField(value = "`name`")
    @ApiModelProperty(value="")
    private String name;

    @TableField(value = "phone")
    @ApiModelProperty(value="")
    private String phone;

    /**
     * 账号类型: 0->禁用；1->启用
     */
    @TableField(value = "`status`")
    @ApiModelProperty(value="账号类型: 0->禁用；1->启用")
    private Integer status;

}