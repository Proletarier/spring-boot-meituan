package com.meituan.waimai.model;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.meituan.waimai.bean.GeoPoint;
import com.meituan.waimai.handler.GeometryTypeHandler;
import com.meituan.waimai.handler.JsonArrayTypeHandler;
import lombok.Data;

@Data
@TableName(autoResultMap = true, value = "_shop")
public class Shop extends BaseEntity {


    @TableField(value = "user_id")
    private Long userId;

    @TableField(value = "category_id")
    private String categoryId;

    @TableField(value = "pic_url")
    private String picUrl;

    @TableField(value = "phone")
    private String phone;

    @TableField(value = "shop_name")
    private String shopName;

    @TableField(value = "bulletin")
    private String bulletin;

    @TableField(value = "address")
    private String address;

    @TableField(value = "location", typeHandler = GeometryTypeHandler.class)
    private GeoPoint location;

    @TableField(value = "shipping_time", typeHandler = JsonArrayTypeHandler.class)
    private JSONArray shippingTime;

    @TableField(value = "sale", typeHandler = FastjsonTypeHandler.class)
    private JSONObject sale;

    @TableField(value = "tag")
    private String tag;

    @TableField(value = "exclusive_delivery")
    private Boolean exclusiveDelivery;
}

