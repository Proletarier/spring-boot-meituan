package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

@ApiModel(value="com-meituan-waimai-model-User")
@Data
@TableName(value = "wm_user")
public class User extends AbstractEntity {

    @TableField(value = "email")
    @ApiModelProperty(value="")
    private String email;

    @TableField(value = "login_time")
    @ApiModelProperty(value="")
    private Date loginTime;

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

    /**
     * 账号类型: 1->系统人员；2->商家
     */
    @TableField(value = "`type`")
    @ApiModelProperty(value="账号类型: 1->系统人员；2->商家")
    private Integer type;

    @TableField(value = "username")
    @ApiModelProperty(value="")
    private String username;
}