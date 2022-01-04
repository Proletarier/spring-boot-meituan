package com.meituan.waimai.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.meituan.waimai.mapper.CustomerMapper;
import com.meituan.waimai.model.Customer;
import com.meituan.waimai.service.CustomerService;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper,Customer> implements CustomerService {

}
