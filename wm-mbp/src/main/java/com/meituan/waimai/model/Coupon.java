package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

@ApiModel(value="com-meituan-waimai-model-Coupon")
@Data
@TableName(value = "wm_coupon")
public class Coupon {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="")
    private Integer id;

    @TableField(value = "amount")
    @ApiModelProperty(value="")
    private Integer amount;

    @TableField(value = "code")
    @ApiModelProperty(value="")
    private String code;

    @TableField(value = "`count`")
    @ApiModelProperty(value="")
    private Integer count;

    @TableField(value = "created_by")
    @ApiModelProperty(value="")
    private String createdBy;

    @TableField(value = "created_date")
    @ApiModelProperty(value="")
    private Date createdDate;

    @TableField(value = "enable_time")
    @ApiModelProperty(value="")
    private Date enableTime;

    @TableField(value = "end_time")
    @ApiModelProperty(value="")
    private Date endTime;

    @TableField(value = "member_level")
    @ApiModelProperty(value="")
    private Integer memberLevel;

    @TableField(value = "min_point")
    @ApiModelProperty(value="")
    private Integer minPoint;

    @TableField(value = "note")
    @ApiModelProperty(value="")
    private String note;

    @TableField(value = "per_limit")
    @ApiModelProperty(value="")
    private Integer perLimit;

    @TableField(value = "publish_count")
    @ApiModelProperty(value="")
    private Integer publishCount;

    @TableField(value = "receive_count")
    @ApiModelProperty(value="")
    private Integer receiveCount;

    @TableField(value = "shop_id")
    @ApiModelProperty(value="")
    private Integer shopId;

    @TableField(value = "`source`")
    @ApiModelProperty(value="")
    private Integer source;

    @TableField(value = "start_time")
    @ApiModelProperty(value="")
    private Date startTime;

    @TableField(value = "updated_by")
    @ApiModelProperty(value="")
    private String updatedBy;

    @TableField(value = "updated_date")
    @ApiModelProperty(value="")
    private Date updatedDate;

    @TableField(value = "use_count")
    @ApiModelProperty(value="")
    private Integer useCount;

    @TableField(value = "use_type")
    @ApiModelProperty(value="")
    private Integer useType;

    @TableField(value = "customer_code")
    @ApiModelProperty(value="")
    private String customerCode;

    @TableField(value = "coupon_id")
    @ApiModelProperty(value="")
    private Long couponId;

    @TableField(value = "customer_id")
    @ApiModelProperty(value="")
    private Long customerId;

    @TableField(value = "customer_name")
    @ApiModelProperty(value="")
    private String customerName;

    @TableField(value = "order_id")
    @ApiModelProperty(value="")
    private Integer orderId;

    @TableField(value = "order_sn")
    @ApiModelProperty(value="")
    private String orderSn;

    @TableField(value = "use_status")
    @ApiModelProperty(value="")
    private Integer useStatus;

    @TableField(value = "use_time")
    @ApiModelProperty(value="")
    private Date useTime;
}