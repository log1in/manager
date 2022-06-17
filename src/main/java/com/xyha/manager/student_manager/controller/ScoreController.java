package com.xyha.manager.student_manager.controller;

import com.xyha.manager.student_manager.entity.Proportion;
import com.xyha.manager.student_manager.service.IProportionService;
import com.xyha.manager.student_manager.service.IScoreService;
import com.xyha.manager.student_manager.vo.StudentScoreVO;
import com.xyha.manager.student_manager.vo.TeacherCourseScoreVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.oas.annotations.EnableOpenApi;

import java.util.List;

@EnableOpenApi
@RestController
@RequestMapping("/v1/score")
@Api("成绩")
public class ScoreController {

    @Autowired
    IScoreService scoreService;
    @Autowired
    IProportionService proportionService;

//    //学生查询自己单科成绩
//    @GetMapping("/s/{studentId}/{studentCourseId}")
//    public StudentScoreVO getOneScoreByStudentCourseId(@PathVariable String studentCourseId, @PathVariable String studentId){
//
//    }
//
    //学生查询自己全科成绩
    @GetMapping("/student")
    @ApiOperation("学生查询自己全科成绩")
    @PreAuthorize("@ex.hasAuthority('student')")
    public List<StudentScoreVO> getAllScoreByStudentId(@RequestParam("studentId") String studentId){
        return scoreService.getAllScoreByStudentId(studentId);
    }

    //教师查询教学班所有学生成绩
    @GetMapping("/teacher")
    @ApiOperation("教师查询教学班所有学生成绩")
    @PreAuthorize("@ex.hasAuthority('teacher')")
    public List<TeacherCourseScoreVO> getAllScoreByTeacherCourseId(@RequestParam("teacherCourseId") String teacherCourseId){
        return scoreService.getAllScoreByTeacherCourseId(teacherCourseId);
    }

    //教师分配成绩比例
    @PostMapping("/proportion")
    @ApiOperation("教师分配成绩比例")
    @PreAuthorize("@ex.hasAuthority('teacher')")
    public boolean insertProportionByTeacherCourseId(@RequestBody Proportion proportion){
        return proportionService.save(proportion);
    }

//    //教师填写教学班所有学生成绩
//    @PostMapping("/teacher")
//    public int fillAllScore(@RequestBody List<StudentScoreVO> list){
//
//    }
//
//    //成绩分析
}
