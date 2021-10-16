package com.meituan.waimai.dao;

import com.meituan.waimai.dto.ShopInfo;
import org.apache.ibatis.annotations.Param;

public interface ShopDao {

    ShopInfo getShopInfo(@Param("id") Integer id);
}
