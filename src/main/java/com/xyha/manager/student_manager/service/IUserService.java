package com.xyha.manager.student_manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xyha.manager.student_manager.entity.User;
import com.xyha.manager.student_manager.vo.CommonResult;
import com.xyha.manager.student_manager.vo.LoginVO;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xyha
 * @since 2022-06-03
 */
public interface IUserService extends IService<User> {

    CommonResult<Map<String, String>> login(LoginVO loginVO);
    CommonResult<String> logout();
}
