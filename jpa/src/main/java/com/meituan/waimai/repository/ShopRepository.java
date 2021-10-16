package com.meituan.waimai.repository;

import com.meituan.waimai.po.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository  extends JpaRepository<Shop, Integer> {
}
