package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="com-meituan-waimai-model-CustomerEnum")
@Data
@TableName(value = "_customer")
public class Customer extends BaseEntity {

    @TableField(value = "face")
    @ApiModelProperty(value="")
    private String face;

    @TableField(value = "phone")
    @ApiModelProperty(value="电话")
    private String phone;

    @TableField(value = "`status`")
    @ApiModelProperty(value="帐号启用状态:0->禁用；1->启用")
    private Integer status;

    @TableField(value = "customer_name")
    @ApiModelProperty(value="")
    private String customerName;

    @TableField(value = "is_member")
    @ApiModelProperty(value="是否是会员")
    private Integer isMember;

}