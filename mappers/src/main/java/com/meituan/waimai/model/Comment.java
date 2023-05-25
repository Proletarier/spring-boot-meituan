package com.meituan.waimai.model;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.meituan.waimai.handler.JsonArrayTypeHandler;
import lombok.Data;

@Data
@TableName(value = "_comment", autoResultMap = true)
public class Comment extends BaseEntity {


    @TableField(value = "`order_id`")
    private Integer orderId;

    @TableField(value = "`customer_id`")
    private Integer customerId;

    @TableField(value = "`shop_id`")
    private Integer shopId;

    @TableField(value = "customer_name")
    private String customerName;

    @TableField(value = "customer_icon")
    private String customerIcon;

    @TableField(value = "delivery_time")
    private String deliveryTime;

    @TableField(value = "`content`")
    private String content;

    @TableField(value = "praise_dish")
    private String praiseDish;

    @TableField(value = "`shop_reply`")
    private String shopReply;

    @TableField(value = "`score`")
    private Double score;

    @TableField(value = "`pictures`", typeHandler = JsonArrayTypeHandler.class)
    private JSONArray pictures;

    @TableField(value = "`good`")
    private Boolean good;

    @TableField(value = "`negative`")
    private Boolean negative;

    @TableField(value = "`picture`")
    private Boolean picture;

    @TableField(value = "`taste`")
    private Boolean taste;

    @TableField(value = "`service`")
    private Boolean service;

    @TableField(value = "`pack`")
    private Boolean pack;

    @TableField(value = "`recommend`")
    private Boolean recommend;

    @TableField(value = "`satisfaction`")
    private Boolean satisfaction;

    @TableField(value = "`weight`")
    private Boolean weight;
}
