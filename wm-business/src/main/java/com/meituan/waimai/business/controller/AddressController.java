package com.meituan.waimai.business.controller;


import com.meituan.waimai.business.bean.CustomerContext;
import com.meituan.waimai.common.api.CommonResult;
import com.meituan.waimai.business.dto.form.CustomerAddressForm;
import com.meituan.waimai.business.server.CustomerAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "地址管理")
@RestController
@RequestMapping("/business/customer_address")
public class AddressController {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CustomerAddressService addressService;

	@ApiOperation(value = "获取当前登录用户的地址列表")
	@GetMapping(value = "/list")
	public CommonResult listAddress()  {
		Integer customerId = CustomerContext.getCustomerId();
		return CommonResult.success(addressService.listAddressByCustomerId(customerId));
	}

	@ApiOperation(value = "新增地址")
	@PostMapping(value = "/save")
	public CommonResult saveAddress(@RequestBody CustomerAddressForm addressForm)  {
		log.info("------ saveAddress param={}", addressForm);
		addressService.saveAddress(addressForm);
		return CommonResult.success();
	}

	@ApiOperation(value = "修改地址")
	@PutMapping(value = "/update")
	public CommonResult updateAddress(@RequestBody CustomerAddressForm addressForm)  {
		log.info("------ updateAddress param={}", addressForm);
		addressService.updateAddress(addressForm);
		return CommonResult.success();
	}

	@ApiOperation(value = "删除当前登录用户的地址")
	@DeleteMapping()
	public CommonResult deleteAddress() {
		log.info("------ deleteAddress param={}", CustomerContext.getCustomerId());
		addressService.deleteAddress(CustomerContext.getCustomerId());
		return CommonResult.success();
	}

}
