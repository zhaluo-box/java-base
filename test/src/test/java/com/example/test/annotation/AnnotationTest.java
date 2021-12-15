package com.example.test.annotation;

import com.example.annotation.CourseInfo;
import com.example.annotation.PersonInfo;
import lombok.SneakyThrows;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 */
public class AnnotationTest {

    @Test
    @SneakyThrows
    public void testAnnotation() {
        System.out.println("===============解析字段注解=====================");
        parseFieldAnnotation();
        System.out.println("=================解析方法注解=====================");
        parseMethodAnnotation();
    }

    private void parseFieldAnnotation() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.example.test.entity.AnnotationTestEntity");
        var declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            if (f.isAnnotationPresent(PersonInfo.class)) {
                var annotation = f.getAnnotation(PersonInfo.class);
                var format = "%s%n";
                System.out.printf((format.repeat(3)), annotation.name(), annotation.age(), annotation.gender());
            }
        }
    }

    @SneakyThrows
    private void parseMethodAnnotation() {
        Class<?> clazz = Class.forName("com.example.test.entity.AnnotationTestEntity");

        var methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(CourseInfo.class)) {
                var annotation = method.getAnnotation(CourseInfo.class);
                var format = "%s%n";
                System.out.printf((format.repeat(4)), annotation.name(), annotation.index(), annotation.profile(), annotation.tag());
            }
        }
    }
}