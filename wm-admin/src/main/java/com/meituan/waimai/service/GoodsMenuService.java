package com.meituan.waimai.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.meituan.waimai.model.GoodsMenu;

import java.util.List;

public interface GoodsMenuService  extends IService<GoodsMenu> {

    List<GoodsMenu> list(Integer pageNum, Integer pageSize, Integer shopId);
}
