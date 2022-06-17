package com.xyha.manager.student_manager.controller;

import com.xyha.manager.student_manager.entity.Student;
import com.xyha.manager.student_manager.utils.ExcelUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Controller
public class PageMapping {
    @PostMapping("file/upload")
    @ResponseBody
    public List<Map<String,String>> ExcelParse(@RequestParam("file") MultipartFile file) throws Exception {
        String name=file.getOriginalFilename();
        System.out.println(name);
        return new ExcelUtils<>(new Student()).AnalysisExcel(file.getInputStream(), name);
    }
}
