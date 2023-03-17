package com.meituan.waimai.model;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import lombok.Data;

@Data
@TableName(value = "_shop")
public class Shop extends BaseEntity {


    @TableField(value = "user_id")
    private Long userId;

    @TableField(value = "category_id")
    private Long categoryId;

    @TableField(value = "pic_url")
    private String picUrl;

    @TableField(value = "phone")
    private String phone;

    @TableField(value = "shop_name")
    private String shopName;

    @TableField(value = "bulletin")
    private String bulletin;

    @TableField(value = "address",typeHandler= FastjsonTypeHandler.class)
    private JSONObject address;

    @TableField(value = "remark",typeHandler= FastjsonTypeHandler.class)
    private JSONObject remark;

    @TableField(value = "delivering",typeHandler= FastjsonTypeHandler.class)
    private JSONObject delivering;
}

