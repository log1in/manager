package com.xyha.manager.student_manager.controller;

import com.xyha.manager.student_manager.service.IStudentService;
import com.xyha.manager.student_manager.vo.StudentVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.oas.annotations.EnableOpenApi;

import java.util.List;

@EnableOpenApi
@RestController
@RequestMapping("/v1/students")
@Api("学生")
public class StudentController {

    @Autowired
    IStudentService studentService;

    //获取学生列表
    @GetMapping("/")
    @ApiOperation("获取学生列表")
    public List<StudentVO> getAllStudents(){
        return studentService.getAllStudents();
    }

    //获取指定学院学生列表
    @GetMapping("/academyName")
    @ApiOperation("获取指定学院学生列表")
    public List<StudentVO> getAllStudentsByAcademy(@RequestParam("academyName") String academyName) {
        return studentService.getAllStudentByAcademy(academyName);
    }

    //获取指定专业学生列表
    @GetMapping("/majorName")
    @ApiOperation("获取指定专业学生列表")
    public List<StudentVO> getAllStudentsByMajor(@RequestParam("majorName") String majorName) {
        return studentService.getAllStudentsByMajor(majorName);
    }

    //获取指定年级学生列表
    @GetMapping("/gradeName")
    @ApiOperation("获取指定年级学生列表")
    public List<StudentVO> getAllStudentsByGrade(@RequestParam("majorName") String majorName, @RequestParam("gradeName") String gradeName) {
        return studentService.getAllStudentsByGrade(majorName,gradeName);
    }


    //获取指定班级学生列表
    @GetMapping("/className")
    @ApiOperation("获取指定班级学生列表")
    public List<StudentVO> getAllStudentsByClass(@RequestParam("majorName") String majorName, @RequestParam("gradeName") String gradeName, @RequestParam("className") String className) {
        return studentService.getAllStudentsByClass(majorName,gradeName,className);
    }

    //获取指定的学生
    @GetMapping("/studentName")
    @ApiOperation("获取指定的学生")
    public StudentVO getOne(@RequestParam("studentName") String studentName){
        return studentService.getOneStudent(studentName);
    }


}
