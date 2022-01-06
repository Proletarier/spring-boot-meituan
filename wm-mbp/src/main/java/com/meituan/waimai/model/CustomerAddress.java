package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

@ApiModel(value="com-meituan-waimai-model-CustomerAddress")
@Data
@TableName(value = "wm_customer_address")
public class CustomerAddress  extends AbstractEntity{

    @TableField(value = "customer_id")
    @ApiModelProperty(value="")
    private Integer customerId;

    @TableField(value = "gender")
    @ApiModelProperty(value="")
    private Integer gender;

    @TableField(value = "house_number")
    @ApiModelProperty(value="")
    private String houseNumber;

    @TableField(value = "`name`")
    @ApiModelProperty(value="")
    private String name;

    @TableField(value = "phone")
    @ApiModelProperty(value="")
    private String phone;

    @TableField(value = "poi")
    @ApiModelProperty(value="")
    private String poi;

}