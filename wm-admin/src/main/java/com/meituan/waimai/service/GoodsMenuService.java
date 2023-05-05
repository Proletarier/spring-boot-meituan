package com.meituan.waimai.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.meituan.waimai.model.Menu;

import java.util.List;

public interface GoodsMenuService  extends IService<Menu> {

    List<Menu> list(Integer pageNum, Integer pageSize, Integer shopId);
}
