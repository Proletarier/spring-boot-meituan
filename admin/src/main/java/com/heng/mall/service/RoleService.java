package com.heng.mall.service;

import com.heng.mall.model.Menu;
import com.heng.mall.model.Role;
import com.heng.mall.model.RoleMenuRelation;
import com.heng.mall.model.RoleResourceRelation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RoleService {

    List<Role> list(Integer pageNum,Integer pageSize,String keyword);

    Role getRole(Integer id);

    int create(Role role);

    int update(Role role);

    int updateStatus(Integer id,Integer status);

    List<RoleMenuRelation>  listRoleMenuRelation(Integer roleId);

    List<RoleResourceRelation> listRoleResourceRelation(Integer roleId);

    @Transactional
    int allocMenu(Integer roleId, List<Integer> menuIds);

    @Transactional
    int allocResource(Integer roleId,List<Integer> resourceIds);
}
