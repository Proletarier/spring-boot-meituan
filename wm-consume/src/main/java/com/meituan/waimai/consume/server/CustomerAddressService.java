package com.meituan.waimai.consume.server;

import com.baomidou.mybatisplus.extension.service.IService;
import com.meituan.waimai.model.CustomerAddress;



public interface CustomerAddressService extends IService<CustomerAddress> {

	void saveAddress(CustomerAddress address);

}
