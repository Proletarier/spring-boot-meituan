package com.meituan.waimai.server;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.meituan.waimai.mapper.CustomerMapper;
import com.meituan.waimai.model.Customer;
import org.springframework.stereotype.Service;


@Service
public class CustomerService extends ServiceImpl<CustomerMapper, Customer>   {


}
