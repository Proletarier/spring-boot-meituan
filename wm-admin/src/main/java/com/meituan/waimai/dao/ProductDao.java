package com.meituan.waimai.dao;

import com.meituan.waimai.dto.ProductInfo;

public interface ProductDao {


    ProductInfo getProductInfo(Integer id);
}
