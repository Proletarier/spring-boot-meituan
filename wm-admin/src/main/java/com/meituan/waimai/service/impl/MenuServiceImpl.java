package com.meituan.waimai.service.impl;

import com.github.pagehelper.PageHelper;
import com.meituan.waimai.dto.MenuNode;
import com.meituan.waimai.mapper.MenuMapper;
import com.meituan.waimai.model.Menu;
import com.meituan.waimai.model.MenuExample;
import com.meituan.waimai.service.MenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;


    @Override
    public List<Menu> list(Integer pageNum, Integer pageSize, Integer parentId) {
        PageHelper.startPage(pageNum, pageSize);
        MenuExample menuExample = new MenuExample();
        menuExample.createCriteria().andParentIdEqualTo(parentId);
        return menuMapper.selectByExample(menuExample);
    }

    @Override
    public int create(Menu menu) {
        menu.setCreateTime(new Date());
        setLevel(menu);
        return menuMapper.insert(menu);
    }

    @Override
    public int update(Menu menu) {
        return menuMapper.updateByPrimaryKeySelective(menu);
    }

    @Override
    public Menu getMenu(Integer id) {
        return menuMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<MenuNode> treeMenuList() {
        List<Menu> menuList = menuMapper.selectByExample(new MenuExample());
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
            Menu parentMenu = menuMapper.selectByPrimaryKey(menu.getParentId());
            if (parentMenu != null) {
                menu.setLevel(parentMenu.getLevel() + 1);
            } else {
                menu.setLevel(0);
            }
        }
    }


}
