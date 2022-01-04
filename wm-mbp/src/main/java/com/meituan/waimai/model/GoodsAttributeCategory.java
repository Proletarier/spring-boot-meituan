package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

@ApiModel(value="com-meituan-waimai-model-GoodsAttributeCategory")
@Data
@TableName(value = "wm_goods_attribute_category")
public class GoodsAttributeCategory {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="")
    private Integer id;

    @TableField(value = "created_by")
    @ApiModelProperty(value="")
    private String createdBy;

    @TableField(value = "created_date")
    @ApiModelProperty(value="")
    private Date createdDate;

    @TableField(value = "select_name")
    @ApiModelProperty(value="")
    private String selectName;

    @TableField(value = "select_type")
    @ApiModelProperty(value="")
    private String selectType;

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