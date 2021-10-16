package com.meituan.waimai.repository;

import com.meituan.waimai.po.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsCategoryRepository extends JpaRepository<Customer, Integer> {
}
