package com.xyha.manager.student_manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xyha.manager.student_manager.entity.Course;
import com.xyha.manager.student_manager.vo.CourseVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author xyha
 * @since 2022-06-03
 */
@Mapper
public interface CourseMapper extends BaseMapper<Course> {


}
