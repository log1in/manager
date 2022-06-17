package com.xyha.manager.student_manager.service.impl;

import com.xyha.manager.student_manager.entity.Teacher;
import com.xyha.manager.student_manager.mapper.TeacherMapper;
import com.xyha.manager.student_manager.service.ITeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyha.manager.student_manager.vo.TeacherVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xyha
 * @since 2022-06-03
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public List<TeacherVO> getAllTeachers() {
        return teacherMapper.getAllTeachers();
    }

    @Override
    public TeacherVO getOneTeacher(String teacherName) {
        return teacherMapper.getOneTeacher(teacherName);
    }
}
