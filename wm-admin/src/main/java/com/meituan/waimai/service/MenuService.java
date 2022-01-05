package com.meituan.waimai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.meituan.waimai.dto.MenuNode;
import com.meituan.waimai.model.Menu;

import java.util.List;

public interface MenuService extends IService<Menu> {

    List<Menu> list(Integer pageNum, Integer pageSize, Integer parentId);

    boolean create(Menu menu);
    /**
     * 查询菜单结构
     * @return
     */
    List<MenuNode> treeMenuList();

}
