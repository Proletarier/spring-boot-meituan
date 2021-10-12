package com.meituan.waimai.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.meituan.waimai.dao.AdminRoleDao;
import com.heng.mall.mapper.RoleMapper;
import com.heng.mall.mapper.RoleMenuRelationMapper;
import com.heng.mall.mapper.RoleResourceRelationMapper;
import com.heng.mall.model.*;
import com.meituan.waimai.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleResourceRelationMapper resourceRelationMapper;

    @Autowired
    private RoleMenuRelationMapper menuRelationMapper;

    @Autowired
    private AdminRoleDao roleDao;

    @Override
    public List<Role> list(Integer pageNum, Integer pageSize, String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        RoleExample example = new RoleExample();
        if (!StrUtil.isEmpty(keyword)) {
            example.createCriteria().andNameLike("%" + keyword + "%");
        }
        return roleMapper.selectByExample(example);
    }

    @Override
    public Role getRole(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int create(Role role) {
        role.setCreateTime(new Date());
        return roleMapper.insert(role);
    }

    @Override
    public int update(Role role) {
        return roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public int updateStatus(Integer id, Integer status) {
        Role role = new Role();
        role.setId(id);
        role.setStatus(status);
        return roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public List<RoleMenuRelation> listRoleMenuRelation(Integer roleId) {
        RoleMenuRelationExample example = new RoleMenuRelationExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        return menuRelationMapper.selectByExample(example);
    }

    @Override
    public List<RoleResourceRelation> listRoleResourceRelation(Integer roleId) {
        RoleResourceRelationExample example=new RoleResourceRelationExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        return  resourceRelationMapper.selectByExample(example);
    }

    @Override
    public int allocMenu(Integer roleId, List<Integer> menuIds) {
        //先删除原来关系
        RoleMenuRelationExample example = new RoleMenuRelationExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        menuRelationMapper.deleteByExample(example);
        //添加对应关系
        for (int i = 0; i < menuIds.size(); i++) {
            RoleMenuRelation relation=new RoleMenuRelation();
            relation.setRoleId(roleId);
            relation.setMenuId(menuIds.get(i));
            menuRelationMapper.insert(relation);
        }
        return 1;
    }

    @Override
    public int allocResource(Integer roleId, List<Integer> resourceIds) {
        //先删除原来关系
        RoleResourceRelationExample example=new RoleResourceRelationExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        resourceRelationMapper.deleteByExample(example);
        // 添加对应关系
        for(int i=0; i<resourceIds.size(); i++){
            RoleResourceRelation relation=new RoleResourceRelation();
            relation.setRoleId(roleId);
            relation.setResourceId(resourceIds.get(i));
            resourceRelationMapper.insert(relation);
        }
        return 1;
    }

}
