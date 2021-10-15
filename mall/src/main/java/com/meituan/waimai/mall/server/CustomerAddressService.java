package com.meituan.waimai.mall.server;

import com.meituan.waimai.mall.dto.form.CustomerAddressForm;
import com.meituan.waimai.mall.dto.vo.CustomerAddressVo;

import java.util.List;

public interface CustomerAddressService {

	List<CustomerAddressVo>  listAddressByCustomerId(Integer customerId);

	void saveAddress(CustomerAddressForm addressForm);

	void updateAddress(CustomerAddressForm addressForm);

	void deleteAddress(Integer addressId);
}
