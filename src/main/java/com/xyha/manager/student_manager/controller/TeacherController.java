package com.xyha.manager.student_manager.controller;

import com.xyha.manager.student_manager.entity.UpdateRequest;
import com.xyha.manager.student_manager.service.ITeacherService;
import com.xyha.manager.student_manager.service.IUpdateRequestService;
import com.xyha.manager.student_manager.vo.TeacherVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.oas.annotations.EnableOpenApi;

import java.util.List;

@EnableOpenApi
@RestController
@RequestMapping("/v1/teachers")
@Api("教师")
public class TeacherController {

    @Autowired
    ITeacherService teacherService;
    @Autowired
    IUpdateRequestService updateRequestService;

    //获取所有教师
    @GetMapping("/")
    @ApiOperation("获取所有教师")
    public List<TeacherVO> getAllTeachers(){
        return teacherService.getAllTeachers();
    }

    //获取指定id的教师
    @GetMapping("/teacherName")
    @ApiOperation("获取指定id的教师")
    public TeacherVO getOne(@RequestParam("teacherName") String teacherName){
        return teacherService.getOneTeacher(teacherName);
    }

    //发起成绩修改请求
    @PostMapping("/request")
    @ApiOperation("发起成绩修改请求")
    @PreAuthorize("@ex.hasAuthority('teacher')")
    public boolean updateScoreRequest(@RequestBody UpdateRequest updateRequest){
        return updateRequestService.save(updateRequest);
    }
}
