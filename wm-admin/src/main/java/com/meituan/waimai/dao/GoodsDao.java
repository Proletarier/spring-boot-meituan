package com.meituan.waimai.dao;

import com.meituan.waimai.dto.ProductInfo;

public interface GoodsDao {


    ProductInfo getGoodsInfo(Integer id);
}
