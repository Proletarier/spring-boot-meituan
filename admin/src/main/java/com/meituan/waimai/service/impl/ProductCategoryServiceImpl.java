package com.meituan.waimai.service.impl;

import com.github.pagehelper.PageHelper;
import com.heng.mall.mapper.ProductCategoryMapper;
import com.heng.mall.model.ProductCategory;
import com.heng.mall.model.ProductCategoryExample;
import com.meituan.waimai.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryMapper categoryMapper;

    @Override
    public List<ProductCategory> list(Integer pageNum, Integer pageSize, Integer shopId) {
        PageHelper.startPage(pageNum, pageSize);
        ProductCategoryExample example = new ProductCategoryExample();
        example.createCriteria().andShopIdEqualTo(shopId);
        return categoryMapper.selectByExample(example);
    }

    @Override
    public ProductCategory getItem(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(ProductCategory productCategory) {
        return categoryMapper.updateByPrimaryKeySelective(productCategory);
    }

    @Override
    public int create(ProductCategory productCategory) {
        return categoryMapper.insertSelective(productCategory);
    }

    @Override
    public int updateStatus(Integer id, Integer status) {
        ProductCategory category = new ProductCategory();
        category.setStatus(status);
        category.setId(id);
        return categoryMapper.updateByPrimaryKeySelective(category);
    }


}
