package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.meituan.waimai.bean.GeoPoint;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "_order")
public class Order extends BaseEntity {

    @TableField(value = "order_sn")
    private String orderSn;

    @TableField(value = "delivery_man_id")
    private Integer deliveryManId;

    @TableField(value = "shop_id")
    private Integer shopId;

    @TableField(value = "user_id")
    private Integer userId;

    @TableField(value = "expect_time")
    private Date expectTime;

    @TableField(value = "total_price")
    private Double totalPrice;

    @TableField(value = "box_price")
    private Double boxPrice;

    @TableField(value = "delivery_price")
    private Double deliveryPrice;

    @TableField(value = "coupon_amount")
    private Double couponAmount;

    @TableField(value = "red_packet_amount")
    private Double redPacketAmount;

    @TableField(value = "subtract_delivery_amount")
    private Double subtractDeliveryAmount;

    @TableField(value = "tableware_count")
    private Integer tablewareCount;

    @TableField(value = "pay_type")
    private Integer payType;

    @TableField(value = "status")
    private Integer status;

    @TableField(value = "receiver_name")
    private String receiverName;

    @TableField(value = "receiver_phone")
    private String receiverPhone;

    @TableField(value = "receiver_address")
    private String receiverAddress;

    @TableField(value = "receiver_address_location")
    private GeoPoint receiverAddressLocation;

    @TableField(value = "delete_status")
    private Integer deleteStatus;
}