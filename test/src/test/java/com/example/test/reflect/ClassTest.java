package com.example.test.reflect;

import org.junit.Test;

/**
 * 反射的学习与复习
 */
public class ClassTest {

    /**
     * 反射class 的学习, 获取class的三种方式,
     * 在JVM中Class 是唯一的
     * result is true all;
     */
    @Test
    public void classTest() throws ClassNotFoundException {
        Class clazz = ClassTest.class;
        Class<? extends ClassTest> getClass = new ClassTest().getClass();
        System.out.println(clazz == getClass);
        Class<?> forName = Class.forName("com.example.test.reflect.ClassTest");
        System.out.println(forName == getClass);
    }
}
