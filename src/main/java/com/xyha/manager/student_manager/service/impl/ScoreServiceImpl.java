package com.xyha.manager.student_manager.service.impl;

import com.xyha.manager.student_manager.entity.Score;
import com.xyha.manager.student_manager.mapper.ScoreMapper;
import com.xyha.manager.student_manager.service.IScoreService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyha.manager.student_manager.vo.StudentScoreVO;
import com.xyha.manager.student_manager.vo.TeacherCourseScoreVO;
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
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score> implements IScoreService {

    @Autowired
    ScoreMapper scoreMapper;

    @Override
    public List<StudentScoreVO> getAllScoreByStudentId(String studentId) {
        return scoreMapper.getAllScoreByStudentId(studentId);
    }

    @Override
    public List<TeacherCourseScoreVO> getAllScoreByTeacherCourseId(String teacherCourseId) {
        return scoreMapper.getAllScoreByTeacherCourseId(teacherCourseId);
    }
}
