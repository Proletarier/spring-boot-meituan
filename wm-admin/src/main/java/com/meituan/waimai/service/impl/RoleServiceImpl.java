package com.meituan.waimai.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.meituan.waimai.dao.AdminRoleDao;
import com.meituan.waimai.mapper.RoleMapper;
import com.meituan.waimai.mapper.RoleMenuRelationMapper;
import com.meituan.waimai.mapper.RoleResourceRelationMapper;
import com.meituan.waimai.model.*;
import com.meituan.waimai.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper,Role> implements RoleService {

    @Autowired
    private RoleResourceRelationMapper resourceRelationMapper;

    @Autowired
    private RoleMenuRelationMapper menuRelationMapper;

    @Autowired
    private AdminRoleDao roleDao;

    @Override
    public List<Role> list(Integer pageNum, Integer pageSize, String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        LambdaQueryWrapper<Role> queryWrapper = new LambdaQueryWrapper();
        if (StrUtil.isNotBlank(keyword)){
            queryWrapper.like(Role::getName,keyword);
        }
        return list(queryWrapper);
    }

    @Override
    public List<RoleMenuRelation> listRoleMenuRelation(Integer roleId) {
        LambdaQueryWrapper<RoleMenuRelation> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(RoleMenuRelation::getRoleId,roleId);
        return menuRelationMapper.selectList(queryWrapper);
    }

    @Override
    public List<RoleResourceRelation> listRoleResourceRelation(Integer roleId) {
        LambdaQueryWrapper<RoleResourceRelation> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(RoleResourceRelation::getRoleId,roleId);
        return  resourceRelationMapper.selectList(queryWrapper);
    }

    @Override
    public int allocMenu(Integer roleId, List<Integer> menuIds) {
        //先删除原来关系
        LambdaQueryWrapper<RoleMenuRelation> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(RoleMenuRelation::getRoleId,roleId);
        menuRelationMapper.delete(queryWrapper);
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
        LambdaQueryWrapper<RoleResourceRelation> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(RoleResourceRelation::getRoleId,roleId);
        resourceRelationMapper.delete(queryWrapper);
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
