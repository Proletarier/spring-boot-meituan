package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(value="com-meituan-waimai-model-Order")
@Data
@TableName(value = "wm_order")
public class Order extends BaseEntity {
}