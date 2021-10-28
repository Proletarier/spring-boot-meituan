package com.meituan.waimai.business.server.impl;

import cn.hutool.core.bean.BeanUtil;
import com.meituan.waimai.amap.api.PoiSearchService;
import com.meituan.waimai.business.dto.form.CustomerAddressForm;
import com.meituan.waimai.business.dto.vo.CustomerAddressVo;
import com.meituan.waimai.business.server.CustomerAddressService;
import com.meituan.waimai.po.CustomerAddress;
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
		List<CustomerAddress> list = addressRepository.findByCustomerId(customerId);

		return list.stream().map(address ->{
			CustomerAddressVo vo=new CustomerAddressVo();
			BeanUtil.copyProperties(address,vo);
			return  vo;
		}).collect(Collectors.toList());
	}

	@Override
	public void saveAddress(CustomerAddressForm addressForm) {
		CustomerAddress customerAddress =new CustomerAddress();
		BeanUtil.copyProperties(addressForm, customerAddress);
		addressRepository.save(customerAddress);
	}

	@Override
	public void updateAddress(CustomerAddressForm addressForm) {
		CustomerAddress customerAddress =new CustomerAddress();
		BeanUtil.copyProperties(addressForm, customerAddress);
		addressRepository.saveAndFlush(customerAddress);
	}

	@Override
	public void deleteAddress(Integer addressId) {
		addressRepository.deleteById(addressId);
	}

}
