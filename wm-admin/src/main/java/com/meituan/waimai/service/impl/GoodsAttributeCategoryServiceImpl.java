package com.meituan.waimai.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.meituan.waimai.dao.GoodsAttributeCategoryDao;
import com.meituan.waimai.dto.ProductAttributeCategoryResult;
import com.meituan.waimai.mapper2.GoodsAttributeCategoryMapper;
import com.meituan.waimai.model.ProductAttributeCategory;
import com.meituan.waimai.service.GoodsAttributeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsAttributeCategoryServiceImpl extends ServiceImpl<GoodsAttributeCategoryMapper, ProductAttributeCategory> implements GoodsAttributeCategoryService {

    @Autowired
    private GoodsAttributeCategoryMapper attributeCategoryMapper;

    @Autowired
    private GoodsAttributeCategoryDao categoryDao;

    @Override
    public List<ProductAttributeCategory> list(Integer pageSize, Integer pageNum, Integer shopId) {
        PageHelper.startPage(pageNum, pageSize);
        LambdaQueryWrapper<ProductAttributeCategory> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(ProductAttributeCategory::getShopId,shopId);
        return list(queryWrapper);
    }


    @Override
    public List<ProductAttributeCategoryResult> listProductAttrCate(Integer shopId) {
        return categoryDao.listProductAttributeCategory(shopId);
    }
}
