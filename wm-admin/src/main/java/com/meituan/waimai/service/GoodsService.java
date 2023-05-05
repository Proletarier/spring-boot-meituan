package com.meituan.waimai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.meituan.waimai.dto.ProductInfo;
import com.meituan.waimai.model.Product;

import java.util.List;

public interface GoodsService extends IService<Product> {

    List<Product> listGoods(Integer pageNum, Integer pageSize, Integer shopId, String name);

    ProductInfo getGoodsInfo(Integer id);
}
