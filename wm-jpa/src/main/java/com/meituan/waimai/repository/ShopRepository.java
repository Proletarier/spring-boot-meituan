package com.meituan.waimai.repository;

import com.meituan.waimai.po.ShopInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository  extends JpaRepository<ShopInfo, Integer> {
}
