package com.heng.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.heng.mall.dao.ProductAttributeCategoryDao;
import com.heng.mall.dto.ProductAttributeCategoryResult;
import com.heng.mall.mapper.ProductAttributeCategoryMapper;
import com.heng.mall.model.ProductAttributeCategory;
import com.heng.mall.model.ProductAttributeCategoryExample;
import com.heng.mall.model.ProductAttributeExample;
import com.heng.mall.service.ProductAttributeCategoryService;
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
