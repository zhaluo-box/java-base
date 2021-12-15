package com.example.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 课程注解
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseInfo {

    /**
     * 课程名称
     */
    String name();

    /**
     * 课程标签
     */
    String tag();

    /**
     * 课程简介
     */
    String profile();

    /**
     * 课程序号
     */
    int index() default 0;
}
