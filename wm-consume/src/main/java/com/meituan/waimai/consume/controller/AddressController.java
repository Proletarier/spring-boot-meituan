package com.meituan.waimai.business.controller;


import com.meituan.waimai.business.bean.CustomerContext;
import com.meituan.waimai.common.api.CommonResult;
import com.meituan.waimai.business.server.CustomerAddressService;
import com.meituan.waimai.po.CustomerAddress;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "地址管理")
@RestController
@RequestMapping("/consume/address")
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
	public CommonResult saveAddress(@RequestBody CustomerAddress address)  {
		log.info("------ saveAddress param={}", address);
		addressService.saveAddress(address);
		return CommonResult.success();
	}

	@ApiOperation(value = "修改地址")
	@PutMapping(value = "/update")
	public CommonResult updateAddress(@RequestBody CustomerAddress address)  {
		log.info("------ updateAddress param={}", address);
		addressService.updateAddress(address);
		return CommonResult.success();
	}

	@ApiOperation(value = "删除当前登录用户的地址")
	@DeleteMapping("/{id}")
	public CommonResult deleteAddress(@PathVariable("id") Integer addressId) {
		log.info("------ deleteAddress param={}", addressId);
		addressService.deleteAddress(addressId);
		return CommonResult.success();
	}

}
