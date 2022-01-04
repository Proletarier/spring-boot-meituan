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
public class Customer {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="")
    private Integer id;

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

    @TableField(value = "created_by")
    @ApiModelProperty(value="")
    private String createdBy;

    @TableField(value = "created_date")
    @ApiModelProperty(value="")
    private Date createdDate;

    @TableField(value = "is_member")
    @ApiModelProperty(value="")
    private Integer isMember;

    @TableField(value = "updated_by")
    @ApiModelProperty(value="")
    private String updatedBy;

    @TableField(value = "updated_date")
    @ApiModelProperty(value="")
    private Date updatedDate;
}