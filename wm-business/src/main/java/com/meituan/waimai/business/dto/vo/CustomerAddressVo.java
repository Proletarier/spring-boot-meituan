package com.meituan.waimai.business.dto.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "CustomerAddressVo",description = "用户地址")
public class CustomerAddressVo {

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
