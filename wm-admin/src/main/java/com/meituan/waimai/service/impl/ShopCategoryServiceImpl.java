package com.meituan.waimai.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.meituan.waimai.dao.ShopCategoryDao;
import com.meituan.waimai.dto.ShopCategoryQueryParam;
import com.meituan.waimai.dto.ShopCategoryWithChildrenItem;
import com.meituan.waimai.mapper.ShopCategoryMapper;
import com.meituan.waimai.model.ShopCategory;
import com.meituan.waimai.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopCategoryServiceImpl extends ServiceImpl<ShopCategoryMapper,ShopCategory> implements ShopCategoryService {

    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Override
    public List<ShopCategory> list(ShopCategoryQueryParam param, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        LambdaQueryWrapper<ShopCategory> queryWrapper = new LambdaQueryWrapper();
        if (param.getParentId() != null) {
            queryWrapper.eq(ShopCategory::getParentId,param.getParentId());
        }
        return list(queryWrapper);
    }

    @Override
    public boolean createShopCategory(ShopCategory shopCategory) {
        setCategoryLevel(shopCategory);
        return save(shopCategory);
    }

    @Override
    public List<ShopCategoryWithChildrenItem> listWithChildrenMap() {
        return shopCategoryDao.listWithChildren();
    }

    private void setCategoryLevel(ShopCategory shopCategory) {
        if (shopCategory.getParentId() == 0) {
            shopCategory.setLevel(1);
        } else {
            ShopCategory parentCategory = getById(shopCategory.getParentId());
            if (parentCategory != null) {
                shopCategory.setLevel(parentCategory.getLevel() + 1);
            } else {
                shopCategory.setLevel(0);
            }
        }
    }
}
