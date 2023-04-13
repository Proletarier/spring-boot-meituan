package com.meituan.waimai.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.meituan.waimai.dto.MenuNode;
import com.meituan.waimai.mapper2.MenuMapper;
import com.meituan.waimai.model.Menu;
import com.meituan.waimai.service.MenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper,Menu> implements MenuService {

    @Override
    public List<Menu> list(Integer pageNum, Integer pageSize, Integer parentId) {
        PageHelper.startPage(pageNum, pageSize);
        LambdaQueryWrapper<Menu> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(Menu::getParentId,parentId);
        return list(queryWrapper);
    }

    @Override
    public boolean create(Menu menu) {
        setLevel(menu);
        return save(menu);
    }

    @Override
    public List<MenuNode> treeMenuList() {
        List<Menu> menuList = list();
        //设置菜单结构
        List<MenuNode> menuNodes = menuList.stream().filter(menu -> menu.getParentId().equals(0)).map(menu -> setChildrenNode(menu, menuList)).collect(Collectors.toList());
        return menuNodes;
    }

    private MenuNode setChildrenNode(Menu menu, List<Menu> menuList) {
        MenuNode menuNode = new MenuNode();
        BeanUtils.copyProperties(menu, menuNode);
        List<MenuNode> nodeList = menuList.stream().filter(children -> children.getParentId().equals(menu.getId())).map(node -> setChildrenNode(node, menuList)).collect(Collectors.toList());
        menuNode.setChildren(nodeList);
        return menuNode;
    }

    private void setLevel(Menu menu) {
        if (menu.getParentId() == 0) {
            menu.setLevel(0);
        } else {
            Menu parentMenu = getById(menu.getParentId());
            if (parentMenu != null) {
                menu.setLevel(parentMenu.getLevel() + 1);
            } else {
                menu.setLevel(0);
            }
        }
    }


}
