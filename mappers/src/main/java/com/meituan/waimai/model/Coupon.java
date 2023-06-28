package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "_coupon")
public class Coupon extends BaseEntity {

    @TableField(value = "type")
    private Integer type;

    @TableField(value = "name")
    private String name;

    @TableField(value = "`count`")
    private Integer count;

    @TableField(value = "amount")
    private Double amount;

    @TableField(value = "valid_day")
    private Integer validDay;

    @TableField(value = "limit_price")
    private Double limitPrice;

    @TableField(value = "end_time")
    private Date endTime;

    @TableField(value = "code")
    private String code;

    @TableField(value = "note")
    private String note;

    @TableField(value = "is_discount")
    private Boolean includeDiscount;

    @TableField(value = "is_box_fee")
    private Boolean includeBoxFee;

    @TableField(value = "is_deliver_fee")
    private Boolean includeDeliverFee;

    @TableField(value = "is_self_phone")
    private Boolean includeSelfPhone;
}