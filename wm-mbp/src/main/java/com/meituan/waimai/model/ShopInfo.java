package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

@ApiModel(value="com-meituan-waimai-model-ShopInfo")
@Data
@TableName(value = "wm_shop_info")
public class ShopInfo {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="")
    private Integer id;

    @TableField(value = "address")
    @ApiModelProperty(value="")
    private String address;

    @TableField(value = "city")
    @ApiModelProperty(value="")
    private String city;

    @TableField(value = "county")
    @ApiModelProperty(value="")
    private String county;

    @TableField(value = "created_by")
    @ApiModelProperty(value="")
    private String createdBy;

    @TableField(value = "created_date")
    @ApiModelProperty(value="")
    private Date createdDate;

    @TableField(value = "pic_url")
    @ApiModelProperty(value="")
    private String picUrl;

    @TableField(value = "shop_name")
    @ApiModelProperty(value="")
    private String shopName;

    @TableField(value = "shop_sn")
    @ApiModelProperty(value="")
    private String shopSn;

    @TableField(value = "`status`")
    @ApiModelProperty(value="")
    private Integer status;

    @TableField(value = "updated_by")
    @ApiModelProperty(value="")
    private String updatedBy;

    @TableField(value = "updated_date")
    @ApiModelProperty(value="")
    private Date updatedDate;
}