package com.meituan.waimai.mall.server.impl;

import cn.hutool.core.bean.BeanUtil;
import com.meituan.waimai.mall.dto.form.CustomerAddressForm;
import com.meituan.waimai.mall.dto.vo.CustomerAddressVo;
import com.meituan.waimai.mall.server.CustomerAddressService;
import com.meituan.waimai.po.UserAddress;
import com.meituan.waimai.repository.CustomerAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerAddressServiceImpl implements CustomerAddressService {

	@Autowired
	CustomerAddressRepository addressRepository;

	@Override
	public List<CustomerAddressVo> listAddressByCustomerId(Integer customerId) {
		List<UserAddress> list = addressRepository.findByCustomerId(customerId);

		return list.stream().map(address ->{
			CustomerAddressVo vo=new CustomerAddressVo();
			BeanUtil.copyProperties(address,vo);
			return  vo;
		}).collect(Collectors.toList());
	}

	@Override
	public void saveAddress(CustomerAddressForm addressForm) {
		UserAddress userAddress =new UserAddress();
		BeanUtil.copyProperties(addressForm, userAddress);
		addressRepository.save(userAddress);
	}

	@Override
	public void updateAddress(CustomerAddressForm addressForm) {
		UserAddress userAddress =new UserAddress();
		BeanUtil.copyProperties(addressForm, userAddress);
		addressRepository.saveAndFlush(userAddress);
	}

	@Override
	public void deleteAddress(Integer addressId) {
		addressRepository.deleteById(addressId);
	}

}
