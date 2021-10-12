package com.meituan.waimai.service;


import com.meituan.waimai.model.Role;
import com.meituan.waimai.model.RoleMenuRelation;
import com.meituan.waimai.model.RoleResourceRelation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RoleService {

    List<Role> list(Integer pageNum, Integer pageSize, String keyword);

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
