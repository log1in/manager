package com.xyha.manager.student_manager.vo;

import lombok.Data;

@Data
public class StudentQueryWrapper {

    private Integer academyId;
    private Integer majorId;
    private Integer gradeId;
    private Integer classId;
    private Integer studentId;
}
