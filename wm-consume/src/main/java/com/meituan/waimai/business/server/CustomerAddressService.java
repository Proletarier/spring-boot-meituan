package com.meituan.waimai.business.server;

import com.meituan.waimai.po.CustomerAddress;

import java.util.List;

public interface CustomerAddressService {

	List<CustomerAddress>  listAddressByCustomerId(Integer customerId);

	void saveAddress(CustomerAddress address);

	void updateAddress(CustomerAddress address);

	void deleteAddress(Integer addressId);
}
