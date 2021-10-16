package com.meituan.waimai.repository;

import com.meituan.waimai.po.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<AdminUser, Integer> {
}
