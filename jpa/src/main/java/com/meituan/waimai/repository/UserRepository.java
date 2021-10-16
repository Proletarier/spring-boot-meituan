package com.meituan.waimai.repository;

import com.meituan.waimai.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Integer> {
}
