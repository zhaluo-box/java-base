package com.example.annotation;

import com.example.enums.GenderType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解测试
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PersonInfo {

    /**
     * 名称
     */
    public String name();

    /**
     * 年龄 默认18岁
     */
    public int age() default 18;

    /**
     * 性别 默认男
     */
    public GenderType gender() default GenderType.MAN;

    /**
     * 开发语言
     */
    public String[] language();

}
