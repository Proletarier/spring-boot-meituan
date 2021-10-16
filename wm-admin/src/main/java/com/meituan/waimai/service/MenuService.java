package com.meituan.waimai.service;

import com.meituan.waimai.dto.MenuNode;
import com.meituan.waimai.model.Menu;

import java.util.List;

public interface MenuService {

    List<Menu> list(Integer pageNum, Integer pageSize, Integer parentId);

    int create(Menu menu);

    int update(Menu  menu);

    Menu getMenu(Integer id);

    /**
     * 查询菜单结构
     * @return
     */
    List<MenuNode> treeMenuList();

}
