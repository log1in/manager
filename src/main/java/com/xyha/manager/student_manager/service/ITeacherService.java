package com.xyha.manager.student_manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xyha.manager.student_manager.entity.Teacher;
import com.xyha.manager.student_manager.vo.TeacherVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xyha
 * @since 2022-06-03
 */
public interface ITeacherService extends IService<Teacher> {

    List<TeacherVO> getAllTeachers();

    TeacherVO getOneTeacher(String teacherName);
}
