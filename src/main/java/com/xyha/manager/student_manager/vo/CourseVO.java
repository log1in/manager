package com.xyha.manager.student_manager.vo;

import lombok.Data;

@Data
public class CourseVO {
    private Integer id;
    private String name;
    private String period;
    private Integer credit;
    private Integer required;
    private Integer academyId;
}
