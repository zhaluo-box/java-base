package com.example.base.test.lang.reflect;

import com.example.base.learn.lang.reflect.SubClass;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;

/**
 * 反射测试
 * Created  on 2022/9/19 12:12:35
 *
 * @author zl
 */
@Slf4j
public class ReflectTest {

    @Test
    @DisplayName("getField() 获取字段测试 ")
    public void getFieldTest() {
        Class<SubClass> clazz = SubClass.class;
        var fields = clazz.getFields();
        log.info("getFields() method result :");
        Arrays.stream(fields).forEach(field -> System.out.println(field.getName()));
        log.info("结论: getFields 只能获取当前类的字段(不包含被private 修饰的其他字段)");
    }

    @Test
    @DisplayName("getDeclaredFields() 获取声明的所有字段测试")
    public void getDeclaredFieldsTest() {
        var aClass = SubClass.class;
        var declaredFields = aClass.getDeclaredFields();
        Arrays.stream(declaredFields).forEach(field -> System.out.println(field.getName()));
        log.info("结论: getDeclaredFields() 只能获取当前类的所有字段");
    }
    
}
