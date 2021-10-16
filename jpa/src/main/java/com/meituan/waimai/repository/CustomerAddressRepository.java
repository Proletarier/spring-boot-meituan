package com.meituan.waimai.repository;

import com.meituan.waimai.po.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerAddressRepository extends JpaRepository<UserAddress, Integer> {

	List<UserAddress> findByCustomerId(Integer customerId);
}
