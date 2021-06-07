package com.heng.mall.dao;

import com.heng.mall.model.Menu;
import com.heng.mall.model.Resource;
import com.heng.mall.model.Role;

import java.util.List;

public interface AdminRoleDao {

     /**
      * 获取账号资源
      * @param adminId
      * @return
      */
     List<Resource> getAdminRoleResourceList(Integer adminId);

     /**
      * 获取账号菜单
      * @param adminId
      * @return
      */
     List<Menu> getAdminRoleMenuList(Integer adminId);


     /**
      * 获取账号角色
      * @param adminId
      * @return
      */
     List<Role> getRoleList(Integer adminId);

}
