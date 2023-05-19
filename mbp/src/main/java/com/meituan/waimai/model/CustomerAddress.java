package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.meituan.waimai.bean.GeoPoint;
import com.meituan.waimai.handler.GeometryTypeHandler;
import lombok.Data;

@Data
@TableName(autoResultMap = true,value = "_customer_address")
public class CustomerAddress  extends BaseEntity {

    @TableField(value = "customer_id")
    private Integer customerId;

    @TableField(value = "gender")
    private Integer gender;

    @TableField(value = "house_number")
    private String houseNumber;

    @TableField(value = "`name`")
    private String name;

    @TableField(value = "phone")
    private String phone;

    @TableField(value = "shipping_address")
    private String shippingAddress;

    @TableField(value = "location", typeHandler= GeometryTypeHandler.class)
    private GeoPoint location;

}