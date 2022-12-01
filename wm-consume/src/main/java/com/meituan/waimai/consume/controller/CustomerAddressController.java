package com.meituan.waimai.consume.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.meituan.waimai.common.model.entity.ObjectKeyConstants;
import com.meituan.waimai.common.model.entity.ResultCode;
import com.meituan.waimai.consume.bean.CustomerContext;
import com.meituan.waimai.common.model.entity.CommonResult;
import com.meituan.waimai.consume.server.CustomerAddressService;
import com.meituan.waimai.mapper.ObjectKeyMapper;
import com.meituan.waimai.model.CustomerAddress;
import com.meituan.waimai.model.ObjectKey;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "地址管理")
@Slf4j
@RestController
@RequestMapping("/customer/address")
public class CustomerAddressController {

	@Autowired
	CustomerAddressService addressService;

	@Autowired
	ObjectKeyMapper objectKeyMapper;

	@ApiOperation(value = "获取当前登录用户的地址列表")
	@GetMapping(value = "/getAddress")
	public CommonResult<List<CustomerAddress>> getAddress()  {
		log.info("[CustomerAddressController]: getAddress");
		Integer customerId = CustomerContext.getCustomerId();
		List<CustomerAddress>  addressList = addressService.list(new QueryWrapper<CustomerAddress>().lambda().eq(CustomerAddress::getCustomerId,customerId));
		return CommonResult.success(addressList);
	}

	@ApiOperation(value = "新增地址")
	@PostMapping(value = "/save")
	public CommonResult<Void> saveAddress(@RequestBody CustomerAddress address)  {
		log.info("------ saveAddress param={}", address);
		if(addressService.saveAddress(address)){
			return CommonResult.success();
		}else{
			return CommonResult.serverFailed();
		}
	}

	@ApiOperation(value = "修改地址")
	@PutMapping(value = "/update")
	public CommonResult<Void> updateAddress(@RequestBody CustomerAddress address)  {
		log.info("------ updateAddress param={}", address);
		Integer customerId = CustomerContext.getCustomerId();

		if(address.getId() == null){
			log.error("CustomerAddressController edit address id not exist");
			return CommonResult.validateFailed();
		}
		LambdaQueryWrapper<CustomerAddress> queryWrapper = new LambdaQueryWrapper();
		queryWrapper.eq(CustomerAddress::getCustomerId,customerId);
		queryWrapper.eq(CustomerAddress::getId,address.getId());
		long ret = addressService.count(queryWrapper);
		if(ret ==  0){
			log.error("updateAddress fail address not exist, params address:{}",address);
			return CommonResult.validateFailed();
		}
		if(!addressService.updateById(address)){
			log.error("updateAddress fail");
			return CommonResult.serverFailed();
		}
		return CommonResult.success();
	}

	@ApiOperation(value = "删除当前登录用户的地址")
	@DeleteMapping("/{id}")
	public CommonResult<Void> deleteAddress(@PathVariable("id") Integer addressId) {
		log.info("------ deleteAddress param={}", addressId);
		Integer customerId = CustomerContext.getCustomerId();
		LambdaQueryWrapper<CustomerAddress> queryWrapper = new LambdaQueryWrapper();
		queryWrapper.eq(CustomerAddress::getCustomerId,customerId);
		queryWrapper.eq(CustomerAddress::getId,addressId);
		long ret = addressService.count(queryWrapper);
		if(ret ==  0){
			log.error("deleteAddress fail address not exist, addressId:{}",addressId);
			return CommonResult.validateFailed();
		}
		if(!addressService.removeById(addressId)){
			log.error("deleteAddress error");
			return CommonResult.failed(ResultCode.SYSTEM_ERROR);
		}
		return CommonResult.success();
	}

	@ApiOperation(value = "获取地址")
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
