package com.xyha.manager.student_manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xyha.manager.student_manager.entity.Teacher;
import com.xyha.manager.student_manager.vo.TeacherVO;
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
public interface TeacherMapper extends BaseMapper<Teacher> {

    @Select(value = "select * from teacher_in_academy")
    List<TeacherVO> getAllTeachers();

    @Select(value = "select * from teacher_in_academy where name=#{teacherName}")
    TeacherVO getOneTeacher(String teacherName);
}
