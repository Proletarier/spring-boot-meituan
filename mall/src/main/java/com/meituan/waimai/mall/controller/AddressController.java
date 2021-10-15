package com.meituan.waimai.mall.controller;


import com.meituan.waimai.common.api.CommonResult;
import com.meituan.waimai.mall.dto.form.CustomerAddressForm;
import com.meituan.waimai.mall.server.CustomerAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "地址管理")
@RestController
@RequestMapping("/address")
public class AddressController {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CustomerAddressService addressService;

	@ApiOperation(value = "地址列表")
	@GetMapping(value = "/list")
	public CommonResult listAddress(@RequestParam("customerId") Integer customerId)  {
		log.info("------ listAddress param={}", customerId);
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

	@DeleteMapping("/{id}")
	public CommonResult deleteAddress(@PathVariable("id") Integer addressId) {
		log.info("------ deleteAddress param={}", addressId);
		addressService.deleteAddress(addressId);
		return CommonResult.success();
	}

}
