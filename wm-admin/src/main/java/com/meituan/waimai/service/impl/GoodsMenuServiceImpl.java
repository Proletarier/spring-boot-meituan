package com.meituan.waimai.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.meituan.waimai.mapper.GoodsMenuMapper;
import com.meituan.waimai.model.GoodsMenu;
import com.meituan.waimai.service.GoodsMenuService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GoodsMenuServiceImpl extends ServiceImpl<GoodsMenuMapper, GoodsMenu> implements GoodsMenuService {

    @Override
    public List<GoodsMenu> list(Integer pageNum, Integer pageSize, Integer shopId) {
        PageHelper.startPage(pageNum, pageSize);
        LambdaQueryWrapper<GoodsMenu> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(GoodsMenu::getShopId,shopId);
        return list(queryWrapper);
    }
}
