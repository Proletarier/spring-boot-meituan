package com.meituan.waimai.dao;


import com.meituan.waimai.model.Menu;
import com.meituan.waimai.model.Resource;
import com.meituan.waimai.model.Role;

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
