package com.meituan.waimai.server;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.meituan.waimai.bean.CustomerContext;
import com.meituan.waimai.mapper.CustomerAddressMapper;
import com.meituan.waimai.model.CustomerAddress;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class CustomerAddressService extends ServiceImpl<CustomerAddressMapper,CustomerAddress>  {

	public boolean saveAddress(CustomerAddress address) {
		address.setCustomerId(CustomerContext.getCustomerId());
		return save(address);
	}

}
