package com.meituan.waimai.model;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import lombok.Data;

@Data
@TableName(value = "_product")
public class Product extends BaseEntity {

    @TableField(value = "shop_id")
    private Integer shopId;

    @TableField(value = "`name`")
    private String name;

    @TableField(value = "image_url")
    private String imageUrl;

    @TableField(value = "introduce")
    private String introduce;

    @TableField(value = "price")
    private Double price;

    @TableField(value = "box_fee")
    private Double boxFee;

    @TableField(value = "stock")
    private String stock;

    @TableField(value = "weight")
    private Integer weight;

    @TableField(value = "unit")
    private Integer unit;

    @TableField(value = "sale", typeHandler = FastjsonTypeHandler.class)
    private JSONObject sale;

    @TableField(value = "must")
    private Boolean must;

    @TableField(value = "sell_status")
    private Boolean sellStatus;

    @TableField(value = "tag")
    private String tag;

}