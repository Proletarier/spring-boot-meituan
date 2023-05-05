package com.meituan.waimai.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;

import com.meituan.waimai.mapper2.GoodsAttributeMapper;
import com.meituan.waimai.model.ProductAttribute;
import com.meituan.waimai.service.GoodsAttributeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsAttributeServiceImpl extends ServiceImpl<GoodsAttributeMapper, ProductAttribute> implements GoodsAttributeService {

    @Override
    public List<ProductAttribute> list(Integer pageNum, Integer pageSize, Integer cateId) {
        PageHelper.startPage(pageNum, pageSize);
        LambdaQueryWrapper<ProductAttribute> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(ProductAttribute::getGoodsAttributeCategoryId,cateId);
        return list(queryWrapper);
    }

}
