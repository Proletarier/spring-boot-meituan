package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

@ApiModel(value="com-meituan-waimai-model-Customer")
@Data
@TableName(value = "wm_customer")
public class Customer extends AbstractEntity {

    @TableField(value = "face")
    @ApiModelProperty(value="")
    private String face;

    @TableField(value = "phone")
    @ApiModelProperty(value="")
    private String phone;

    /**
     * 帐号启用状态:0->禁用；1->启用
     */
    @TableField(value = "`status`")
    @ApiModelProperty(value="帐号启用状态:0->禁用；1->启用")
    private Integer status;

    @TableField(value = "customer_name")
    @ApiModelProperty(value="")
    private String customerName;

    @TableField(value = "is_member")
    @ApiModelProperty(value="")
    private Integer isMember;

}