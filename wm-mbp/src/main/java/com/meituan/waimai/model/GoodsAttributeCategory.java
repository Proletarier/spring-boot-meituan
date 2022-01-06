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
public class GoodsAttributeCategory extends AbstractEntity {

    @TableField(value = "select_name")
    @ApiModelProperty(value="")
    private String selectName;

    @TableField(value = "select_type")
    @ApiModelProperty(value="")
    private String selectType;

    @TableField(value = "shop_id")
    @ApiModelProperty(value="")
    private Integer shopId;

}