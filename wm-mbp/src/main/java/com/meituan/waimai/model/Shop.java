package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

@ApiModel(value="com-meituan-waimai-model-Shop")
@Data
@TableName(value = "wm_shop")
public class Shop extends AbstractEntity {


    @TableField(value = "email")
    @ApiModelProperty(value="")
    private String email;

    @TableField(value = "phone")
    @ApiModelProperty(value="")
    private String phone;

    @TableField(value = "shop_name")
    @ApiModelProperty(value="")
    private String shopName;

}