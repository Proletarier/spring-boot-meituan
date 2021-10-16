package com.meituan.waimai.repository;

import com.meituan.waimai.po.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository  extends JpaRepository<Menu, Integer> {
}
