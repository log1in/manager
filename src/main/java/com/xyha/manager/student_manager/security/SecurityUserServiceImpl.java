package com.xyha.manager.student_manager.security;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xyha.manager.student_manager.entity.Permission;
import com.xyha.manager.student_manager.entity.User;
import com.xyha.manager.student_manager.mapper.PermissionMapper;
import com.xyha.manager.student_manager.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class SecurityUserServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * 根据用户名查找数据库，判断是否存在这个用户
     * */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //查询用户信息
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,username);
        User user = userMapper.selectOne(queryWrapper);
        //如果没有查询到用户就抛出异常
        if(Objects.isNull(user)){
            throw new RuntimeException("用户名或者密码错误");
        }

        List<Permission> permissions = permissionMapper.getUserRolesByUserId(user.getId());
        List<String> grantedAuthorities = new ArrayList<>();
        permissions.forEach(sysPermission -> {
            String perm = sysPermission.getLevel();
            grantedAuthorities.add(perm);
        });

        return new LoginUser(user,grantedAuthorities);
    }
}
