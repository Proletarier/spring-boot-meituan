package com.meituan.waimai.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.meituan.waimai.dto.SystemMenuNode;
import com.meituan.waimai.mapper2.SystemMenuMapper;
import com.meituan.waimai.model.SystemMenu;
import com.meituan.waimai.service.MenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl extends ServiceImpl<SystemMenuMapper, SystemMenu> implements MenuService {

    @Override
    public List<SystemMenu> list(Integer pageNum, Integer pageSize, Integer parentId) {
        PageHelper.startPage(pageNum, pageSize);
        LambdaQueryWrapper<SystemMenu> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(SystemMenu::getParentId,parentId);
        return list(queryWrapper);
    }

    @Override
    public boolean create(SystemMenu systemMenu) {
        setLevel(systemMenu);
        return save(systemMenu);
    }

    @Override
    public List<SystemMenuNode> treeMenuList() {
        List<SystemMenu> systemMenuList = list();
        //设置菜单结构
        List<SystemMenuNode> menuNodes = systemMenuList.stream().filter(menu -> menu.getParentId().equals(0)).map(menu -> setChildrenNode(menu, systemMenuList)).collect(Collectors.toList());
        return menuNodes;
    }

    private SystemMenuNode setChildrenNode(SystemMenu systemMenu, List<SystemMenu> systemMenuList) {
        SystemMenuNode menuNode = new SystemMenuNode();
        BeanUtils.copyProperties(systemMenu, menuNode);
        List<SystemMenuNode> nodeList = systemMenuList.stream().filter(children -> children.getParentId().equals(systemMenu.getId())).map(node -> setChildrenNode(node, systemMenuList)).collect(Collectors.toList());
        menuNode.setChildren(nodeList);
        return menuNode;
    }

    private void setLevel(SystemMenu systemMenu) {
        if (systemMenu.getParentId() == 0) {
            systemMenu.setLevel(0);
        } else {
            SystemMenu parentSystemMenu = getById(systemMenu.getParentId());
            if (parentSystemMenu != null) {
                systemMenu.setLevel(parentSystemMenu.getLevel() + 1);
            } else {
                systemMenu.setLevel(0);
            }
        }
    }


}
