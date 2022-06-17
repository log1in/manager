package com.xyha.manager.student_manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xyha.manager.student_manager.entity.Student;
import com.xyha.manager.student_manager.vo.StudentVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xyha
 * @since 2022-06-03
 */
public interface IStudentService extends IService<Student> {

    List<StudentVO> getAllStudentByAcademy(String academyName);

    List<StudentVO> getAllStudentsByMajor(String majorName);

    List<StudentVO> getAllStudentsByGrade(String majorName, String gradeName);

    List<StudentVO> getAllStudentsByClass(String majorName, String gradeName, String className);

    StudentVO getOneStudent(String studentName);

    List<StudentVO> getAllStudents();
}
