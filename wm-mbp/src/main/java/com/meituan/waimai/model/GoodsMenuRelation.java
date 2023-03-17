package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="com-meituan-waimai-model-GoodsMenuRelation")
@Data
@TableName(value = "wm_goods_menu_relation")
public class GoodsMenuRelation  extends BaseEntity {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="")
    private Integer id;

    @TableField(value = "goods_id")
    @ApiModelProperty(value="")
    private String goodsId;

    @TableField(value = "menu_id")
    @ApiModelProperty(value="")
    private String menuId;

    @TableField(value = "shop_id")
    @ApiModelProperty(value="")
    private Integer shopId;

}