package com.meituan.waimai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.meituan.waimai.dto.ProductAttributeCategoryResult;
import com.meituan.waimai.model.ProductAttributeCategory;

import java.util.List;

public interface GoodsAttributeCategoryService extends IService<ProductAttributeCategory> {

    List<ProductAttributeCategory> list(Integer pageSize, Integer pageNum, Integer shopId);

    List<ProductAttributeCategoryResult> listProductAttrCate(Integer shopId);
}
