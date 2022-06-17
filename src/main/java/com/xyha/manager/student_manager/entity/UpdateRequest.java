package com.xyha.manager.student_manager.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author xyha
 * @since 2022-06-03
 */
@Data
@EqualsAndHashCode()
public class UpdateRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("teacher_id")
    private Integer teacherId;

    @TableField("admin_id")
    private Integer adminId;

    /**
     * 0未审核1已审核
     */
    @TableField("status")
    private Integer status;

    @TableField("student_course_id")
    private Integer studentCourseId;

    @TableField("request_info")
    private String requestInfo;


}
