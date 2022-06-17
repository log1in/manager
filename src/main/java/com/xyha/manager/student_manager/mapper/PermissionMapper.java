package com.xyha.manager.student_manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xyha.manager.student_manager.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xyha
 * @since 2022-06-03
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

    @Select(value = "SELECT permission.`level` FROM `user_role` LEFT JOIN role ON user_role.role_id=role.id\n" +
            "LEFT JOIN role_permission ON user_role.role_id=role_permission.role_id\n" +
            "LEFT JOIN permission ON permission.id=role_permission.permission_id\n" +
            "WHERE\n" +
            "user_id=#{id}")
    List<Permission> getUserRolesByUserId(Integer id);
}
