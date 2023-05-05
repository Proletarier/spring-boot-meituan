package com.meituan.waimai.service;



import com.baomidou.mybatisplus.extension.service.IService;
import com.meituan.waimai.model.ProductAttribute;

import java.util.List;


public interface GoodsAttributeService extends IService<ProductAttribute> {

    List<ProductAttribute> list(Integer pageNum, Integer pageSize, Integer cateId);

}
