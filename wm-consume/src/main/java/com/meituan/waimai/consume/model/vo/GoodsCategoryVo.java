package com.meituan.waimai.consume.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GoodsCategoryVo {

	@ApiModelProperty(value = "分类id")
	private Integer cateId;
	@ApiModelProperty(value = "图标")
	private String icon;
	@ApiModelProperty(value = "分类名称")
	private String name;
}
