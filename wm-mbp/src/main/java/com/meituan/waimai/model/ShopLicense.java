package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

@ApiModel(value="com-meituan-waimai-model-ShopLicense")
@Data
@TableName(value = "wm_shop_license")
public class ShopLicense {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="")
    private Integer id;

    @TableField(value = "address")
    @ApiModelProperty(value="")
    private String address;

    @TableField(value = "business_scope")
    @ApiModelProperty(value="")
    private String businessScope;

    @TableField(value = "company_name")
    @ApiModelProperty(value="")
    private String companyName;

    @TableField(value = "company_owner")
    @ApiModelProperty(value="")
    private String companyOwner;

    @TableField(value = "created_by")
    @ApiModelProperty(value="")
    private String createdBy;

    @TableField(value = "created_date")
    @ApiModelProperty(value="")
    private Date createdDate;

    @TableField(value = "enroll_time")
    @ApiModelProperty(value="")
    private Date enrollTime;

    @TableField(value = "expire_time")
    @ApiModelProperty(value="")
    private Date expireTime;

    @TableField(value = "idacrd_name")
    @ApiModelProperty(value="")
    private String idacrdName;

    @TableField(value = "idcard_img")
    @ApiModelProperty(value="")
    private String idcardImg;

    @TableField(value = "idcard_num")
    @ApiModelProperty(value="")
    private String idcardNum;

    @TableField(value = "qualify_pics")
    @ApiModelProperty(value="")
    private String qualifyPics;

    @TableField(value = "shop_id")
    @ApiModelProperty(value="")
    private Integer shopId;

    @TableField(value = "updated_by")
    @ApiModelProperty(value="")
    private String updatedBy;

    @TableField(value = "updated_date")
    @ApiModelProperty(value="")
    private Date updatedDate;
}