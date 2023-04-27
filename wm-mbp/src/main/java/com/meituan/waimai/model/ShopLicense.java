package com.meituan.waimai.model;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.meituan.waimai.handler.JsonArrayTypeHandler;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "_shop_license")
public class ShopLicense  extends BaseEntity {

    @TableField(value = "shop_id")
    private Integer shopId;

    @TableField(value = "address")
    private String address;

    @TableField(value = "business_scope")
    private String businessScope;

    @TableField(value = "company_name")
    private String companyName;

    @TableField(value = "company_owner")
    private String companyOwner;

    @TableField(value = "enroll_time")
    private Date enrollTime;

    @TableField(value = "expire_time")
    private Date expireTime;

    @TableField(value = "qualify_pics", typeHandler = JsonArrayTypeHandler.class)
    private JSONArray qualifyPics;
}