package com.meituan.waimai.service;

import com.heng.mall.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> list(Integer pageNum, Integer pageSize);
}