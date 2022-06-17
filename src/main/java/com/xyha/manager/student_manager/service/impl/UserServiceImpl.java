package com.xyha.manager.student_manager.service.impl;

import com.xyha.manager.student_manager.entity.User;
import com.xyha.manager.student_manager.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyha.manager.student_manager.security.LoginUser;
import com.xyha.manager.student_manager.service.IUserService;
import com.xyha.manager.student_manager.utils.JwtUtil;
import com.xyha.manager.student_manager.utils.RedisCache;
import com.xyha.manager.student_manager.vo.CommonResult;
import com.xyha.manager.student_manager.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xyha
 * @since 2022-06-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Override
    public CommonResult<Map<String, String>> login(LoginVO loginVO) {
        UsernamePasswordAuthenticationToken token =new UsernamePasswordAuthenticationToken(loginVO.getUsername(),loginVO.getPassword());
        Authentication authentication = authenticationManager.authenticate(token);
        if(Objects.isNull(authentication)){
            throw new RuntimeException("登录失败");
        }
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        String userid = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userid);
        Map<String,String> map = new HashMap<>();
        map.put("token",jwt);
        //把完整的用户信息存入redis  userid作为key
        redisCache.setCacheObject("login:"+userid,loginUser);
        return CommonResult.success(map);
    }
    @Override
    public CommonResult<String> logout() {
        //获取SecurityContextHolder中的用户id
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        int userid = loginUser.getUser().getId();
        //删除redis中的值
        redisCache.deleteObject("login:"+userid);
        return CommonResult.success("注销成功");
    }
}
