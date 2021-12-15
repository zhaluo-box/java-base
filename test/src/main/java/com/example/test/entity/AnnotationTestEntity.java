package com.example.test.entity;

import com.example.annotation.CourseInfo;
import com.example.annotation.PersonInfo;

/**
 *
 */
public class AnnotationTestEntity {

    @PersonInfo(name = "张三", language = { "C++", "GO", "JAVA" })
    private String auther;

    @CourseInfo(name = "语文", tag = "基础课程", profile = "好好学习", index = 10)
    public void getCourseInfo() {

    }

}
