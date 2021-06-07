package com.heng.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.heng.mall.dao.ShopCategoryDao;
import com.heng.mall.dto.ShopCategoryQueryParam;
import com.heng.mall.dto.ShopCategoryWithChildrenItem;
import com.heng.mall.mapper.ShopCategoryMapper;
import com.heng.mall.model.ShopCategory;
import com.heng.mall.model.ShopCategoryExample;
import com.heng.mall.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {

    @Autowired
    private ShopCategoryMapper shopCategoryMapper;

    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Override
    public List<ShopCategory> list(ShopCategoryQueryParam param, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        ShopCategoryExample example = new ShopCategoryExample();
        ShopCategoryExample.Criteria criteria = example.createCriteria();
        if (param.getParentId() != null) {
            criteria.andParentIdEqualTo(param.getParentId());
        }
        return shopCategoryMapper.selectByExample(example);
    }

    @Override
    public int createShopCategory(ShopCategory shopCategory) {
        shopCategory.setCount(0);
        setCategoryLevel(shopCategory);
        return shopCategoryMapper.insertSelective(shopCategory);
    }

    @Override
    public int updateShopCategory(ShopCategory shopCategory) {
        return shopCategoryMapper.updateByPrimaryKeySelective(shopCategory);
    }

    @Override
    public int updateStatus(Integer cateId, Integer status) {
        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setStatus(status);
        shopCategory.setId(cateId);
        return shopCategoryMapper.updateByPrimaryKeySelective(shopCategory);
    }

    @Override
    public ShopCategory getShopCategory(Integer cateId) {
        return shopCategoryMapper.selectByPrimaryKey(cateId);
    }

    @Override
    public List<ShopCategoryWithChildrenItem> listWithChildrenMap() {
        return shopCategoryDao.listWithChildren();
    }

    private void setCategoryLevel(ShopCategory shopCategory) {
        if (shopCategory.getParentId() == 0) {
            shopCategory.setLevel(1);
        } else {
            ShopCategory parentCategory = shopCategoryMapper.selectByPrimaryKey(shopCategory.getParentId());
            if (parentCategory != null) {
                shopCategory.setLevel(parentCategory.getLevel() + 1);
            } else {
                shopCategory.setLevel(0);
            }
        }
    }
}
