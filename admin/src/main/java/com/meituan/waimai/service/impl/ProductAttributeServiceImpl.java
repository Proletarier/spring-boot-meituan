package com.meituan.waimai.service.impl;

import com.github.pagehelper.PageHelper;

import com.meituan.waimai.mapper.ProductAttributeMapper;
import com.meituan.waimai.model.ProductAttribute;
import com.meituan.waimai.model.ProductAttributeExample;
import com.meituan.waimai.service.ProductAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductAttributeServiceImpl implements ProductAttributeService {

    @Autowired
    private ProductAttributeMapper attributeMapper;

    @Override
    public List<ProductAttribute> list(Integer pageNum, Integer pageSize, Integer cateId) {
        PageHelper.startPage(pageNum, pageSize);
        ProductAttributeExample example = new ProductAttributeExample();
        example.createCriteria().andProductAttributeCategoryIdEqualTo(cateId);
        return attributeMapper.selectByExample(example);
    }

    @Override
    public int create(ProductAttribute productAttribute) {
        return attributeMapper.insertSelective(productAttribute);
    }

    @Override
    public int update(ProductAttribute productAttribute) {
        return attributeMapper.updateByPrimaryKey(productAttribute);
    }
}
