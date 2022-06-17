package com.xyha.manager.student_manager.service.impl;

import com.xyha.manager.student_manager.entity.Course;
import com.xyha.manager.student_manager.mapper.CourseMapper;
import com.xyha.manager.student_manager.service.ICourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xyha
 * @since 2022-06-03
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {

    @Autowired
    CourseMapper courseMapper;


}
