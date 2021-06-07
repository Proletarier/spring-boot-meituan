package com.heng.mall.service;

import com.heng.mall.dto.MenuNode;
import com.heng.mall.model.Menu;

import java.util.List;

public interface MenuService {

    List<Menu> list(Integer pageNum,Integer pageSize,Integer parentId);

    int create(Menu menu);

    int update(Menu  menu);

    Menu getMenu(Integer id);

    /**
     * 查询菜单结构
     * @return
     */
    List<MenuNode> treeMenuList();

}
