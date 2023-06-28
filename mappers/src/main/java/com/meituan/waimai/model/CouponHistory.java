package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "_coupon_history")
public class CouponHistory extends BaseEntity {

    @TableField(value = "customer_id")
    private Integer customerId;

    @TableField(value = "coupon_id")
    private Integer couponId;

    @TableField(value = "coupon_code")
    private String couponCode;

    @TableField(value = "get_type")
    private String getType;

    @TableField(value = "use_status")
    private Integer useStatus;

    @TableField(value = "use_time")
    private Date useTime;

    @TableField(value = "end_time")
    private Date endTime;

    @TableField(value = "order_id")
    private Integer orderId;

    @TableField(value = "order_sn")
    private String orderSn;
}
