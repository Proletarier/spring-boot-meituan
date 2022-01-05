package com.meituan.waimai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.meituan.waimai.dto.GoodsAttributeCategoryResult;
import com.meituan.waimai.model.GoodsAttributeCategory;

import java.util.List;

public interface GoodsAttributeCategoryService extends IService<GoodsAttributeCategory> {

    List<GoodsAttributeCategory> list(Integer pageSize, Integer pageNum, Integer shopId);

    List<GoodsAttributeCategoryResult> listProductAttrCate(Integer shopId);
}
