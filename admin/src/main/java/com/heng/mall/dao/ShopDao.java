package com.heng.mall.dao;

import com.heng.mall.dto.ShopInfo;
import org.apache.ibatis.annotations.Param;

public interface ShopDao {

    ShopInfo getShopInfo(@Param("id") Integer id);
}
