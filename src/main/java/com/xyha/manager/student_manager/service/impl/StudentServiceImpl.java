package com.xyha.manager.student_manager.service.impl;

import com.xyha.manager.student_manager.entity.Student;
import com.xyha.manager.student_manager.mapper.StudentMapper;
import com.xyha.manager.student_manager.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyha.manager.student_manager.vo.StudentVO;
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
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Autowired
    StudentMapper studentMapper;
    @Override
    public List<StudentVO> getAllStudentByAcademy(String academyName) {
        return studentMapper.getAllStudentByAcademy(academyName);
    }

    @Override
    public List<StudentVO> getAllStudentsByMajor(String majorName) {
        return studentMapper.getAllStudentsByMajor(majorName);
    }

    @Override
    public List<StudentVO> getAllStudentsByGrade(String majorName, String gradeName) {
        return studentMapper.getAllStudentsByGrade(majorName,gradeName);
    }

    @Override
    public List<StudentVO> getAllStudentsByClass(String majorName, String gradeName, String className) {
        return studentMapper.getAllStudentsByClass(majorName,gradeName,className);
    }

    @Override
    public StudentVO getOneStudent(String studentName) {
        return studentMapper.getOneStudent(studentName);
    }

    @Override
    public List<StudentVO> getAllStudents() {
        return studentMapper.getAllStudents();
    }
}
