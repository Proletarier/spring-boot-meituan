package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

@ApiModel(value="com-meituan-waimai-model-GoodsAttributeValue")
@Data
@TableName(value = "wm_goods_attribute_value")
public class GoodsAttributeValue {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="")
    private Integer id;

    @TableField(value = "created_by")
    @ApiModelProperty(value="")
    private String createdBy;

    @TableField(value = "created_date")
    @ApiModelProperty(value="")
    private Date createdDate;

    @TableField(value = "goods_attribute_category_id")
    @ApiModelProperty(value="")
    private Integer goodsAttributeCategoryId;

    @TableField(value = "goods_attribute_id")
    @ApiModelProperty(value="")
    private Integer goodsAttributeId;

    @TableField(value = "goods_id")
    @ApiModelProperty(value="")
    private Integer goodsId;

    @TableField(value = "shop_id")
    @ApiModelProperty(value="")
    private Integer shopId;

    @TableField(value = "updated_by")
    @ApiModelProperty(value="")
    private String updatedBy;

    @TableField(value = "updated_date")
    @ApiModelProperty(value="")
    private Date updatedDate;

    @TableField(value = "`value`")
    @ApiModelProperty(value="")
    private String value;
}