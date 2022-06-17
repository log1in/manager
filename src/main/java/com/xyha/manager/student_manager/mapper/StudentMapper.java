package com.xyha.manager.student_manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xyha.manager.student_manager.entity.Student;
import com.xyha.manager.student_manager.vo.StudentVO;
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
public interface StudentMapper extends BaseMapper<Student> {

    @Select(value = "select * from student_in_academy where academy_name=#{academyName}")
    List<StudentVO> getAllStudentByAcademy(String academyName);

    @Select(value = "select * from student_in_academy where major_name=#{majorName}")
    List<StudentVO> getAllStudentsByMajor(String majorName);

    @Select(value = "select * from student_in_academy where major_name=#{majorName} and grade_name=#{gradeName}")
    List<StudentVO> getAllStudentsByGrade(String majorName, String gradeName);

    @Select(value = "select * from student_in_academy where major_name=#{majorName} and grade_name=#{gradeName} and class_name=#{className}")
    List<StudentVO> getAllStudentsByClass(String majorName, String gradeName, String className);

    @Select(value = "select * from student_in_academy where name=#{studentName}")
    StudentVO getOneStudent(String studentName);

    @Select(value = "select * from student_in_academy")
    List<StudentVO> getAllStudents();
}
