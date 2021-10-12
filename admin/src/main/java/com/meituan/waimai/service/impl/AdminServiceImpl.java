package com.meituan.waimai.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.meituan.waimai.common.exception.Asserts;
import com.meituan.waimai.dao.AdminRoleDao;

import com.meituan.waimai.mapper.AdminMapper;
import com.meituan.waimai.mapper.AdminRoleRelationMapper;
import com.meituan.waimai.model.*;
import com.meituan.waimai.security.util.JwtTokenUtil;
import com.meituan.waimai.service.AdminCacheService;
import com.meituan.waimai.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AdminServiceImpl implements AdminService {


    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private AdminRoleRelationMapper adminRoleRelationMapper;
    @Autowired
    private AdminRoleDao adminRoleDao;
    @Autowired
    private AdminCacheService adminCacheService;


    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = loadUserByUsername(username);
            System.out.println(passwordEncoder.encode(password));
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                Asserts.fail("密码不正确");
            }
            if (!userDetails.isEnabled()) {
                Asserts.fail("帐号已被禁用");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
            insertLoginLog(username);
        } catch (AuthenticationException e) {
            log.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    private void insertLoginLog(String username) {
        Admin admin = getAdminByUsername(username);
        if (admin == null) return;
//        UmsAdminLoginLog loginLog = new UmsAdminLoginLog();
//        loginLog.setAdminId(admin.getId());
//        loginLog.setCreateTime(new Date());
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        loginLog.setIp(RequestUtil.getRequestIp(request));
//        loginLogMapper.insert(loginLog);
    }

    @Override
    public List<Admin> list(Integer pageNum, Integer pageSize, String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        if (!StrUtil.isEmpty(keyword)) {
            criteria.andNickNameLike("%" + keyword + "%");
            example.or(example.createCriteria().andUsernameLike("%" + keyword + "%"));
        }
        return adminMapper.selectByExample(example);
    }

    @Override
    public int update(Admin admin) {
        return adminMapper.updateByPrimaryKeySelective(admin);
    }

    @Override
    public int create(Admin admin) {
        admin.setCreateTime(new Date());
        admin.setStatus(1);
        //查询是否有相同用户名的用户
        AdminExample example = new AdminExample();
        example.createCriteria().andUsernameEqualTo(admin.getUsername());
        List<Admin> umsAdminList = adminMapper.selectByExample(example);
        if (umsAdminList.size() > 0) {
            Asserts.fail("账号已存在");
        }
        //设置默认密码并加密
        String encodePassword = passwordEncoder.encode("123456");
        admin.setPassword(encodePassword);
        adminMapper.insert(admin);
        return 1;
    }

    @Override
    public Admin getItem(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateStatus(Integer id, Integer status) {
        Admin admin = new Admin();
        admin.setId(id);
        admin.setStatus(status);
        return adminMapper.updateByPrimaryKeySelective(admin);
    }

    @Override
    public int updatePassword(Integer id, String oldPassword, String newPassword) {
        return 0;
    }

    @Override
    public int resetPassword(Integer id) {
        Admin admin = adminMapper.selectByPrimaryKey(id);
        String password = passwordEncoder.encode("123456");
        admin.setPassword(password);
        return adminMapper.updateByPrimaryKeySelective(admin);
    }

    @Override
    public Admin getAdminByUsername(String username) {
        //获取用户信息
        AdminExample example = new AdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<Admin> adminList = adminMapper.selectByExample(example);

        if (adminList != null && adminList.size() > 0) {
            return adminList.get(0);
        }
        return null;
    }

    @Override
    public int allotRole(Integer adminId, List<Integer> roleIds) {
        AdminRoleRelationExample example = new AdminRoleRelationExample();
        example.createCriteria().andAdminIdEqualTo(adminId);
        adminRoleRelationMapper.deleteByExample(example);

        //添加
        for (int i = 0; i < roleIds.size(); i++) {
            AdminRoleRelation relation = new AdminRoleRelation();
            relation.setAdminId(adminId);
            relation.setRoleId(roleIds.get(i));
            adminRoleRelationMapper.insert(relation);
        }

        return 1;
    }

    @Override
    public List<AdminRoleRelation> getRole(Integer adminId) {
        AdminRoleRelationExample example = new AdminRoleRelationExample();
        example.createCriteria().andAdminIdEqualTo(adminId);
        return adminRoleRelationMapper.selectByExample(example);
    }

    @Override
    public List<Role> getRoleList(Integer adminId) {
        return  adminRoleDao.getRoleList(adminId);
    }

    @Override
    public List<Resource> getResourceList(Integer adminId) {
        List<Resource> list = adminCacheService.getResourceList(adminId);
        if (CollUtil.isNotEmpty(list)) {
            return list;
        }
        list = adminRoleDao.getAdminRoleResourceList(adminId);
        if(CollUtil.isNotEmpty(list)){
            adminCacheService.setResourceList(adminId,list);
        }
        return list;
    }

    @Override
    public List<Menu> getRoleMenuByAdminId(Integer adminId) {
        return adminRoleDao.getAdminRoleMenuList(adminId);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        //获取用户信息
        Admin admin = getAdminByUsername(username);
        if (admin != null) {
            List<Resource> resourceList = getResourceList(admin.getId());
            List<GrantedAuthority> authorities = resourceList.stream().map(resource -> new SimpleGrantedAuthority(resource.getId() + ":" + resource.getName())).collect(Collectors.toList());
            return new User(admin.getUsername(),
                    admin.getPassword(), authorities);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }
}
