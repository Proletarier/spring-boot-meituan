package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "_menu_product_relation")
public class MenuProductRelation extends BaseEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "menu_id")
    private Integer menuId;

    @TableField(value = "product_id")
    private Integer productId;


}