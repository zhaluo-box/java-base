package org.example.common.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 学生
 * Created  on 2023/7/13 15:15:58
 *
 * @author zl
 */
@Data
@Accessors(chain = true)
public class Student {

    private String name;

    private int age;

    private String address;

    /**
     * 课程列表
     * 一个学生有多个课程
     */
    private List<Course> courseList;
}
