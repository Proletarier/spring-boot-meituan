package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

@ApiModel(value="com-meituan-waimai-model-Goods")
@Data
@TableName(value = "wm_goods")
public class Goods extends AbstractEntity {

    @TableField(value = "goods_desc")
    @ApiModelProperty(value="")
    private String goodsDesc;

    @TableField(value = "`name`")
    @ApiModelProperty(value="")
    private String name;

    @TableField(value = "picture")
    @ApiModelProperty(value="")
    private String picture;

    @TableField(value = "price")
    @ApiModelProperty(value="")
    private Integer price;

    @TableField(value = "sell_status")
    @ApiModelProperty(value="")
    private Integer sellStatus;

    @TableField(value = "shop_id")
    @ApiModelProperty(value="")
    private Integer shopId;

    @TableField(value = "tag_ids")
    @ApiModelProperty(value="")
    private String tagIds;

    @TableField(value = "goods_type")
    @ApiModelProperty(value="")
    private Integer goodsType;

    @TableField(value = "unit")
    @ApiModelProperty(value="")
    private String unit;

}