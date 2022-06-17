package com.xyha.manager.student_manager.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xyha.manager.student_manager.entity.User;
import com.xyha.manager.student_manager.service.IUserService;
import com.xyha.manager.student_manager.vo.CommonResult;
import com.xyha.manager.student_manager.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    @Autowired
    IUserService userService;

//    //根据id查找用户
//    @GetMapping("/user")
//    public UserVO getUser(@RequestParam("id") String id) {
//
//    }
//
    //修改手机号
    @PatchMapping("/tel")
    public boolean updateUserTel(@RequestParam("userId") String userId, @RequestParam("tel") String tel){
        return userService.update(new UpdateWrapper<User>().eq("id",userId).set("telephone",tel));
    }
//
//    //修改密码
//    @PatchMapping("/{userId}/password")
//    public int updateUserPassword(@PathVariable("userId") String userId){
//        return
//    }
//
//    //增加用户
//    @PostMapping("/user")
//    public int insertUser(@RequestBody UserVO userVO){
//
//    }
//
//    //批量增加用户
//    @PostMapping("/batch")
//    public int batchInsertUsers(@RequestParam("file") MultipartFile file) throws IOException {
//        String filename = file.getOriginalFilename();
//        List<Map<String, String>> list = new ExcelUtils<>(new UserVO()).AnalysisExcel(file.getInputStream(), filename);
//
//    }
//
    //登录
    @PostMapping("/login")
    public CommonResult<Map<String, String>> login(@RequestBody LoginVO loginVO){
        return userService.login(loginVO);
    }

    @GetMapping("/logout")
    public CommonResult<String> logout(){
        return userService.logout();
    }

}
