package com.meituan.waimai.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.meituan.waimai.model.Role;
import com.meituan.waimai.model.RoleMenuRelation;
import com.meituan.waimai.model.RoleResourceRelation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RoleService  extends IService<Role> {

    List<Role> list(Integer pageNum, Integer pageSize, String keyword);

    List<RoleMenuRelation>  listRoleMenuRelation(Integer roleId);

    List<RoleResourceRelation> listRoleResourceRelation(Integer roleId);

    @Transactional
    int allocMenu(Integer roleId, List<Integer> menuIds);

    @Transactional
    int allocResource(Integer roleId,List<Integer> resourceIds);
}
