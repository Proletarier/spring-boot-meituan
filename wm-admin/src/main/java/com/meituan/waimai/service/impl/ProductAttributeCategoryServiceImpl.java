package com.meituan.waimai.service.impl;

import com.github.pagehelper.PageHelper;
import com.meituan.waimai.dao.ProductAttributeCategoryDao;
import com.meituan.waimai.dto.ProductAttributeCategoryResult;
import com.meituan.waimai.mapper.ProductAttributeCategoryMapper;
import com.meituan.waimai.model.ProductAttributeCategory;
import com.meituan.waimai.model.ProductAttributeCategoryExample;
import com.meituan.waimai.service.ProductAttributeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductAttributeCategoryServiceImpl implements ProductAttributeCategoryService {

    @Autowired
    private ProductAttributeCategoryMapper attributeCategoryMapper;

    @Autowired
    private ProductAttributeCategoryDao categoryDao;

    @Override
    public List<ProductAttributeCategory> list(Integer pageSize, Integer pageNum, Integer shopId) {
        PageHelper.startPage(pageNum, pageSize);
        ProductAttributeCategoryExample example = new ProductAttributeCategoryExample();
        example.createCriteria().andShopIdEqualTo(shopId);
        return attributeCategoryMapper.selectByExample(example);
    }

    @Override
    public int create(ProductAttributeCategory category) {
        return attributeCategoryMapper.insertSelective(category);
    }

    @Override
    public int update(ProductAttributeCategory category) {
        return attributeCategoryMapper.updateByPrimaryKeySelective(category);
    }

    @Override
    public List<ProductAttributeCategoryResult> listProductAttrCate(Integer shopId) {
        return categoryDao.listProductAttributeCategory(shopId);
    }
}
