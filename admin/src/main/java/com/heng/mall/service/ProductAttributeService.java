package com.heng.mall.service;

import com.heng.mall.model.ProductAttribute;

import java.util.List;

public interface ProductAttributeService {

    List<ProductAttribute> list(Integer pageNum, Integer pageSize, Integer cateId);

    int create(ProductAttribute productAttribute);

    int update(ProductAttribute productAttribute);
}
