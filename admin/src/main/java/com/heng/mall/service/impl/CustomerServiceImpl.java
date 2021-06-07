package com.heng.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.heng.mall.mapper.CustomerMapper;
import com.heng.mall.model.Customer;
import com.heng.mall.model.CustomerExample;
import com.heng.mall.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;


    @Override
    public List<Customer> list(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        CustomerExample example = new CustomerExample();
        return customerMapper.selectByExample(example);
    }
}
