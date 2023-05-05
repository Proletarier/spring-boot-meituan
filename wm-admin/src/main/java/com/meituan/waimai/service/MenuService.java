package com.meituan.waimai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.meituan.waimai.dto.SystemMenuNode;
import com.meituan.waimai.model.SystemMenu;

import java.util.List;

public interface MenuService extends IService<SystemMenu> {

    List<SystemMenu> list(Integer pageNum, Integer pageSize, Integer parentId);

    boolean create(SystemMenu systemMenu);
    /**
     * 查询菜单结构
     * @return
     */
    List<SystemMenuNode> treeMenuList();

}
