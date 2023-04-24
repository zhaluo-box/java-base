package com.example.base.test.lang.reflect;

import com.example.base.learn.lang.reflect.SubClass;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

    @Test
    @DisplayName("反射测试方法的名称")
    @SneakyThrows
    public void getMethodParamTypeName() {
        var methodTest = new ReflectTest().getClass().getMethod("methodTest", Map.class);
        System.out.println(methodTest.getGenericParameterTypes()[0].getTypeName());
    }

    public List<Long> methodTest(Map<String, List<Object>> param) {

        return null;
    }

}
