package com.meituan.waimai.consume.server.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.meituan.waimai.consume.bean.CustomerContext;
import com.meituan.waimai.consume.server.CustomerAddressService;
import com.meituan.waimai.mapper.CustomerAddressMapper;
import com.meituan.waimai.model.CustomerAddress;
import org.springframework.stereotype.Service;


@Service
public class CustomerAddressServiceImpl extends ServiceImpl<CustomerAddressMapper,CustomerAddress> implements CustomerAddressService {

	@Override
	public void saveAddress(CustomerAddress address) {
		address.setCustomerId(CustomerContext.getCustomerId());
		save(address);
	}

}
