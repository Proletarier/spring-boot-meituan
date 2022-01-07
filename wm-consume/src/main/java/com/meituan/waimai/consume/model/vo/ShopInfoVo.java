package com.meituan.waimai.consume.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ShopInfoVo {


	@ApiModelProperty(value = "商店")
	private Integer shopId;
	@ApiModelProperty(value = "商店图标")
	private String icon;
	@ApiModelProperty(value = "商店名称")
	private String shopName;
}
