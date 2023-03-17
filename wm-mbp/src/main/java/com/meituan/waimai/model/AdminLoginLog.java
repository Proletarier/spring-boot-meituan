package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="com-meituan-waimai-model-AdminLoginLog")
@Data
@TableName(value = "wm_admin_login_log")
public class AdminLoginLog extends BaseEntity {

    @TableField(value = "address")
    @ApiModelProperty(value="")
    private String address;

    @TableField(value = "admin_user_id")
    @ApiModelProperty(value="")
    private Integer adminUserId;

    @TableField(value = "ip")
    @ApiModelProperty(value="")
    private String ip;

    @TableField(value = "user_agent")
    @ApiModelProperty(value="")
    private String userAgent;
}