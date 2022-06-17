package com.xyha.manager.student_manager.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xyha.manager.student_manager.entity.UpdateRequest;
import com.xyha.manager.student_manager.service.IUpdateRequestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.oas.annotations.EnableOpenApi;

import java.util.List;

@EnableOpenApi
@RestController
@RequestMapping("/v1/admin")
@Api("管理员")
public class AdminController {

    @Autowired
    IUpdateRequestService updateRequestService;

    //获取所有请求列表
    @GetMapping("/requests")
    @ApiOperation("获取所有成绩修改请求")
    @PreAuthorize("@ex.hasAuthority('admin')")
    public List<UpdateRequest> getAllRequests(){
        return updateRequestService.list(new QueryWrapper<UpdateRequest>().eq("status", 0));
    }
//
//    //获取指定请求
//    @GetMapping("/requests/requestId")
//    public RequestVO getOneRequest(@RequestParam("requestId") String requestId){
//
//    }
//
    //处理修改成绩请求
    @PatchMapping("/requests/requestId")
    @ApiOperation("处理成绩修改请求")
    @PreAuthorize("@ex.hasAuthority('admin')")
    public boolean updateRequest(@RequestParam("requestId") String requestId, @RequestParam("adminId") String adminId){
        return updateRequestService.update(new UpdateWrapper<UpdateRequest>().set("status", 1).set("admin_id", adminId).eq("id", requestId));
    }


}
