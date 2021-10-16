package com.meituan.waimai.service;


import com.meituan.waimai.model.ProductAttribute;

import java.util.List;

public interface ProductAttributeService {

    List<ProductAttribute> list(Integer pageNum, Integer pageSize, Integer cateId);

    int create(ProductAttribute productAttribute);

    int update(ProductAttribute productAttribute);
}
