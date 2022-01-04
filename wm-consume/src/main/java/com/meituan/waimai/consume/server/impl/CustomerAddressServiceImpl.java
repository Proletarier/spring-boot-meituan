package com.meituan.waimai.business.server.impl;

import com.meituan.waimai.business.bean.CustomerContext;
import com.meituan.waimai.business.server.CustomerAddressService;
import com.meituan.waimai.po.CustomerAddress;
import com.meituan.waimai.repository.CustomerAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerAddressServiceImpl implements CustomerAddressService {

	@Autowired
	CustomerAddressRepository addressRepository;

	@Override
	public List<CustomerAddress> listAddressByCustomerId(Integer customerId) {
		return addressRepository.findByCustomerId(customerId);
	}

	@Override
	public void saveAddress(CustomerAddress address) {
		address.setCustomerId(CustomerContext.getCustomerId());
		addressRepository.save(address);
	}

	@Override
	public void updateAddress(CustomerAddress address) {
		addressRepository.saveAndFlush(address);
	}

	@Override
	public void deleteAddress(Integer addressId) {
		addressRepository.deleteById(addressId);
	}

}
