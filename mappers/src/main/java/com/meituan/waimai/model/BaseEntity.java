package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public abstract class BaseEntity {

	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	@TableField(value = "created_date",fill = FieldFill.INSERT)
	private Date createdDate;

	@TableField(value = "updated_date",fill = FieldFill.INSERT_UPDATE)
	private Date updatedDate;
}
