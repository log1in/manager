package com.xyha.manager.student_manager.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xyha.manager.student_manager.entity.Course;
import com.xyha.manager.student_manager.entity.StudentCourse;
import com.xyha.manager.student_manager.entity.TeacherCourse;
import com.xyha.manager.student_manager.service.ICourseService;
import com.xyha.manager.student_manager.service.IStudentCourseService;
import com.xyha.manager.student_manager.service.ITeacherCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.oas.annotations.EnableOpenApi;

import java.util.List;

@EnableOpenApi
@RestController
@RequestMapping("/v1/courses")
@Api("课程")
public class CourseController {

    @Autowired
    ICourseService courseService;
    @Autowired
    ITeacherCourseService teacherCourseService;
    @Autowired
    IStudentCourseService studentCourseService;

    //管理员添加课程信息
    @PostMapping("/course")
    @ApiOperation("管理员添加课程信息")
    @PreAuthorize("@ex.hasAuthority('admin')")
    public boolean insertCourse(@RequestBody Course course){
        return courseService.save(course);
    }

    //管理员修改课程信息

    //管理员删除课程信息
    @DeleteMapping("/course")
    @ApiOperation("管理员删除课程信息")
    @PreAuthorize("@ex.hasAuthority('admin')")
    public boolean deleteCourse(@RequestParam("courseId") String courseId){
        return courseService.removeById(courseId);
    }

    //查询所有课程信息
    @GetMapping("/course/list")
    @ApiOperation("查询所有课程信息")
    @PreAuthorize("@ex.hasAuthority('admin')")
    public List<Course> getAllCourse(){
        return courseService.list();
    }

    //查询指定课程信息
    @GetMapping("/course")
    @ApiOperation("查询指定课程信息")
    @PreAuthorize("@ex.hasAuthority('admin')")
    public Course getOneCourse(@RequestParam("courseId") String courseId){
        return courseService.getById(courseId);
    }

    //学生查询修读课
    @GetMapping("/learnt")
    @ApiOperation("学生查询修读课")
    @PreAuthorize("@ex.hasAuthority('student')")
    public List<StudentCourse> getAllStudentCourse(@RequestParam("studentId") String studentId){
        return studentCourseService.list(new QueryWrapper<StudentCourse>().eq("student_id",studentId));
    }

    //教师查询所有讲授课
    @GetMapping("/taught")
    @ApiOperation("教师查询所有讲授课")
    @PreAuthorize("@ex.hasAuthority('teacher')")
    public List<TeacherCourse> getAllTaught(@RequestParam("teacherId") String teacherId){
        return teacherCourseService.list(new QueryWrapper<TeacherCourse>().eq("teacher_id",teacherId));
    }

    //管理员查询所有讲授课
    @GetMapping("/teacherCourses")
    @ApiOperation("管理员查询所有讲授课")
    @PreAuthorize("@ex.hasAuthority('admin')")
    public List<TeacherCourse> getAllTeacherCourse(){
        return teacherCourseService.list();
    }



    //管理员设置讲授课
    @PostMapping("/taught")
    @ApiOperation("管理员设置讲授课")
    @PreAuthorize("@ex.hasAuthority('admin')")
    public boolean setTeacherCourse(@RequestBody TeacherCourse teacherCourse){
        return teacherCourseService.save(teacherCourse);
    }


}
