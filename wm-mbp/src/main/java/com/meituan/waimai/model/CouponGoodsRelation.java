package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

@ApiModel(value="com-meituan-waimai-model-CouponGoodsRelation")
@Data
@TableName(value = "wm_coupon_goods_relation")
public class CouponGoodsRelation {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="")
    private Integer id;

    @TableField(value = "coupon_id")
    @ApiModelProperty(value="")
    private Integer couponId;

    @TableField(value = "created_by")
    @ApiModelProperty(value="")
    private String createdBy;

    @TableField(value = "created_date")
    @ApiModelProperty(value="")
    private Date createdDate;

    @TableField(value = "goods_id")
    @ApiModelProperty(value="")
    private Integer goodsId;

    @TableField(value = "goods_name")
    @ApiModelProperty(value="")
    private String goodsName;

    @TableField(value = "goods_sn")
    @ApiModelProperty(value="")
    private String goodsSn;

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