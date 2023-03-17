package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="com-meituan-waimai-model-ShopInfo")
@Data
@TableName(value = "wm_shop_info")
public class ShopInfo extends BaseEntity {

    @TableField(value = "address")
    @ApiModelProperty(value="")
    private String address;

    @TableField(value = "city")
    @ApiModelProperty(value="")
    private String city;

    @TableField(value = "county")
    @ApiModelProperty(value="")
    private String county;

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

}