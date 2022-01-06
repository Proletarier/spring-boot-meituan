package com.meituan.waimai.consume.controller;


import com.meituan.waimai.consume.bean.CustomerContext;
import com.meituan.waimai.common.api.CommonResult;
import com.meituan.waimai.consume.server.CustomerAddressService;
import com.meituan.waimai.model.CustomerAddress;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "地址管理")
@RestController
@RequestMapping("/consume/address")
@Slf4j
public class AddressController {

	@Autowired
	CustomerAddressService addressService;

	@ApiOperation(value = "获取当前登录用户的地址列表")
	@GetMapping(value = "/list")
	public CommonResult listAddress()  {
		Integer customerId = CustomerContext.getCustomerId();
		return CommonResult.success(addressService.getById(customerId));
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
		return CommonResult.success(addressService.updateById(address));
	}

	@ApiOperation(value = "删除当前登录用户的地址")
	@DeleteMapping("/{id}")
	public CommonResult deleteAddress(@PathVariable("id") Integer addressId) {
		log.info("------ deleteAddress param={}", addressId);
		return CommonResult.success(addressService.removeById(addressId));
	}

}
