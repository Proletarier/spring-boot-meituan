package com.meituan.waimai.repository;

import com.meituan.waimai.po.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<Admin, Integer> {
}
