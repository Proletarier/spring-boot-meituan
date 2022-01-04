package com.meituan.waimai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.meituan.waimai.model.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AdminService extends IService<AdminUser> {

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    String login(String username, String password);

    /**
     * 用户列表
     * @param pageNum
     * @param pageSize
     * @param keyword
     * @return
     */
    List<AdminUser> list(Integer pageNum, Integer pageSize, String keyword);

    /**
     * 创建用户
     * @param admin
     * @return
     */
    boolean create(AdminUser admin);

    /**
     * 更新密码
     * @param id
     * @param oldPassword
     * @param newPassword
     * @return
     */
    int updatePassword(Integer id,String oldPassword,String newPassword);

    /**
     * 重置密码
     * @param id
     * @return
     */
    boolean resetPassword(Integer id);

    /**
     * 获取用户信息
     * @param username
     * @return
     */
    AdminUser getAdminByUsername(String username);

    /**
     * 设置用户角色
     * @param adminId
     * @param roleIds
     * @return
     */
    @Transactional
    int allotRole(Integer adminId,List<Integer> roleIds);

    /**
     * 查询用户角色关系
     * @param adminId
     * @return
     */
    List<AdminRoleRelation> getRole(Integer adminId);

    /**
     * 获取账号角色
     * @return
     */
    List<Role> getRoleList(Integer adminId);

    /**
     * 获取指定用户的可访问资源
     */
    List<Resource> getResourceList(Integer adminId);

    /**
     * 获取用户菜单
     * @param adminId
     * @return
     */
    List<Menu>  getRoleMenuByAdminId(Integer adminId);


    UserDetails loadUserByUsername(String username);


}
