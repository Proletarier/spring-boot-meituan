package com.meituan.waimai.business.server;

import com.meituan.waimai.business.dto.form.CustomerAddressForm;
import com.meituan.waimai.business.dto.vo.CustomerAddressVo;
import com.meituan.waimai.po.CustomerAddress;

import java.util.List;

public interface CustomerAddressService {

	List<CustomerAddress>  listAddressByCustomerId(Integer customerId);

	void saveAddress(CustomerAddressForm addressForm);

	void updateAddress(CustomerAddressForm addressForm);

	void deleteAddress(Integer addressId);
}
