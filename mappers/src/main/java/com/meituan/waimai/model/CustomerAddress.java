package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.meituan.waimai.bean.GeoPoint;
import com.meituan.waimai.handler.GeometryTypeHandler;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@TableName(autoResultMap = true,value = "_customer_address")
public class CustomerAddress  extends BaseEntity {

    @TableField(value = "customer_id")
    private Integer customerId;

    @TableField(value = "gender")
    @NotNull
    private Integer gender;

    @TableField(value = "house_number")
    @NotBlank
    private String houseNumber;

    @TableField(value = "`name`")
    @NotBlank
    private String name;

    @TableField(value = "phone")
    @NotBlank
    private String phone;

    @TableField(value = "shipping_address")
    @NotBlank
    private String shippingAddress;

    @TableField(value = "location", typeHandler= GeometryTypeHandler.class)
    @NotNull
    private GeoPoint location;

}