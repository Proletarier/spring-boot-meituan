package com.meituan.waimai.repository;

import com.meituan.waimai.po.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CustomerRepository  extends JpaRepository<User, Integer> {

	User findByPhone(String phone);
}
