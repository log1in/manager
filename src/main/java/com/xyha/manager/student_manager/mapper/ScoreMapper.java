package com.xyha.manager.student_manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xyha.manager.student_manager.entity.Score;
import com.xyha.manager.student_manager.vo.StudentScoreVO;
import com.xyha.manager.student_manager.vo.TeacherCourseScoreVO;
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
public interface ScoreMapper extends BaseMapper<Score> {

    @Select(value = "SELECT course_name,SUM(mark) AS total,status\n" +
            "FROM student_score\n" +
            "WHERE student_id=#{studentId}\n" +
            "GROUP BY student_course_id\n")
    List<StudentScoreVO> getAllScoreByStudentId(String studentId);

    @Select(value = "SELECT student_name,course_name,status,name,mark FROM student_score where teacher_course_id=#{teacherCourseId}")
    List<TeacherCourseScoreVO> getAllScoreByTeacherCourseId(String teacherCourseId);
}
