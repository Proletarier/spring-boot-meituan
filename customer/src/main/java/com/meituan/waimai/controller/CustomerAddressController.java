package com.meituan.waimai.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.meituan.waimai.common.domain.ObjectKeyConstants;
import com.meituan.waimai.common.domain.ResultCode;
import com.meituan.waimai.bean.CustomerContext;
import com.meituan.waimai.common.domain.CommonResult;
import com.meituan.waimai.server.CustomerAddressService;
import com.meituan.waimai.mapper.ObjectKeyMapper;
import com.meituan.waimai.model.CustomerAddress;
import com.meituan.waimai.model.ObjectKey;

import com.meituan.waimai.validation.AddressValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/customer/address")
public class CustomerAddressController {

	@Autowired
    CustomerAddressService addressService;
	@Autowired
	ObjectKeyMapper objectKeyMapper;
	@Autowired
	AddressValidator validator;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@GetMapping(value = "/getAddress")
	public CommonResult<List<CustomerAddress>> getAddress()  {
		log.debug("[CustomerAddressController]: getAddress");
		Integer customerId = CustomerContext.getCustomerId();
		List<CustomerAddress>  addressList = addressService.list(new QueryWrapper<CustomerAddress>().lambda().eq(CustomerAddress::getCustomerId,customerId));
		return CommonResult.success(addressList);
	}

	@PostMapping(value = "/save")
	public CommonResult<Void> saveAddress(@RequestBody @Validated CustomerAddress address)  {
		log.debug("[saveAddress] param={}", address);
		if(addressService.saveAddress(address)){
			return CommonResult.success();
		}else{
			return CommonResult.serverFailed();
		}
	}

	@PutMapping(value = "/update")
	public CommonResult<Void> updateAddress(@RequestBody @Validated  CustomerAddress address)  {
		log.debug("------ updateAddress param={}", address);
		if(!addressService.updateById(address)){
			log.error("address modify fail");
			return CommonResult.serverFailed();
		}
		return CommonResult.success();
	}

	@DeleteMapping("/{id}")
	public CommonResult<Void> deleteAddress(@PathVariable("id") @Validated Integer addressId) {
		log.debug("------ deleteAddress param={}", addressId);
		if(!addressService.removeById(addressId)){
			log.error("address remove failed");
			return CommonResult.failed(ResultCode.SYSTEM_ERROR);
		}
		return CommonResult.success();
	}

	@GetMapping("/{id}")
	public CommonResult<CustomerAddress> getAddress(@PathVariable("id") Integer addressId) {
		Integer customerId = CustomerContext.getCustomerId();
		LambdaQueryWrapper<CustomerAddress> queryWrapper = new LambdaQueryWrapper();
		queryWrapper.eq(CustomerAddress::getCustomerId,customerId);
		queryWrapper.eq(CustomerAddress::getId,addressId);
		return CommonResult.success(addressService.getOne(queryWrapper));
	}

	@GetMapping("/getCityList")
	public CommonResult<Object>  getCityList() {
		ObjectKey objectKey = objectKeyMapper.selectOne(new QueryWrapper<ObjectKey>().lambda().eq(ObjectKey::getObjectKey, ObjectKeyConstants.CITY_LIST));
		if(objectKey == null){
			return CommonResult.success();
		}else {
			return CommonResult.success(objectKey.getObjectValue());
		}
	}

}
