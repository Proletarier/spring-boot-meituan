package com.meituan.waimai.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public abstract class AbstractEntity  {

	@ApiModelProperty(value="主键")
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	@ApiModelProperty(value="创建人")
	@TableField(value = "created_by",fill = FieldFill.INSERT)
	private String createdBy;

	@ApiModelProperty(value="创建时间")
	@TableField(value = "created_date",fill = FieldFill.INSERT)
	private Date createdDate;

	@ApiModelProperty(value="修改人")
	@TableField(value = "updated_by",fill = FieldFill.INSERT_UPDATE)
	private String updatedBy;

	@ApiModelProperty(value="修改时间")
	@TableField(value = "updated_date",fill = FieldFill.INSERT_UPDATE)
	private Date updatedDate;
}
