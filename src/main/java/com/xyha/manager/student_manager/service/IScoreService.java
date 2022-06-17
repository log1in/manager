package com.xyha.manager.student_manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xyha.manager.student_manager.entity.Score;
import com.xyha.manager.student_manager.vo.StudentScoreVO;
import com.xyha.manager.student_manager.vo.TeacherCourseScoreVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xyha
 * @since 2022-06-03
 */
public interface IScoreService extends IService<Score> {

    List<StudentScoreVO> getAllScoreByStudentId(String studentId);

    List<TeacherCourseScoreVO> getAllScoreByTeacherCourseId(String teacherCourseId);
}
