package com.meituan.waimai.repository;

import com.meituan.waimai.po.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository  extends JpaRepository<Customer, Integer> {

	Customer findByPhone(String phone);
}
