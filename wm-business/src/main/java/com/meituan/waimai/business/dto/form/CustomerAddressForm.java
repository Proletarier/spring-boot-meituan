package com.meituan.waimai.business.dto.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CustomerAddressForm {

	private Integer addressId;

	@ApiModelProperty(value="客户姓名")
	private String name;

	@ApiModelProperty(value="性别")
	private Integer gender;

	@ApiModelProperty(value="电话")
	private String phone;

	@ApiModelProperty(value="门牌号")
	private String houseNumber;

	@ApiModelProperty(value="坐标")
	private String poi;

}
