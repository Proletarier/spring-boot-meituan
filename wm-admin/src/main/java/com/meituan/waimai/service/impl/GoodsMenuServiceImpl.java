package com.meituan.waimai.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.meituan.waimai.mapper2.GoodsMenuMapper;
import com.meituan.waimai.model.Menu;
import com.meituan.waimai.service.GoodsMenuService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GoodsMenuServiceImpl extends ServiceImpl<GoodsMenuMapper, Menu> implements GoodsMenuService {

    @Override
    public List<Menu> list(Integer pageNum, Integer pageSize, Integer shopId) {
        PageHelper.startPage(pageNum, pageSize);
        LambdaQueryWrapper<Menu> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(Menu::getShopId,shopId);
        return list(queryWrapper);
    }
}
