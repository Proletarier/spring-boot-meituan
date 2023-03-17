package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@ApiModel(value="com-meituan-waimai-model-OrderComment")
@Data
@TableName(value = "wm_order_comment")
public class OrderComment extends BaseEntity {

    @TableField(value = "comment_time")
    @ApiModelProperty(value="")
    private Date commentTime;

    @TableField(value = "content")
    @ApiModelProperty(value="")
    private String content;

    @TableField(value = "delivery_score")
    @ApiModelProperty(value="")
    private BigDecimal deliveryScore;

    @TableField(value = "pack_score")
    @ApiModelProperty(value="")
    private BigDecimal packScore;

    @TableField(value = "pictures")
    @ApiModelProperty(value="")
    private String pictures;

    @TableField(value = "quality_score")
    @ApiModelProperty(value="")
    private BigDecimal qualityScore;

    @TableField(value = "score")
    @ApiModelProperty(value="")
    private BigDecimal score;

    @TableField(value = "shop_id")
    @ApiModelProperty(value="")
    private Integer shopId;

    @TableField(value = "user_id")
    @ApiModelProperty(value="")
    private Integer userId;
}