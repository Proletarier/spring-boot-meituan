package com.meituan.waimai.consume.server.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.meituan.waimai.consume.bean.CustomerContext;
import com.meituan.waimai.consume.server.CustomerAddressService;
import com.meituan.waimai.mapper.CustomerAddressMapper;
import com.meituan.waimai.model.CustomerAddress;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class CustomerAddressServiceImpl extends ServiceImpl<CustomerAddressMapper,CustomerAddress> implements CustomerAddressService {

	@Override
	public boolean saveAddress(CustomerAddress address) {
		address.setCustomerId(CustomerContext.getCustomerId());
		return save(address);
	}

}
