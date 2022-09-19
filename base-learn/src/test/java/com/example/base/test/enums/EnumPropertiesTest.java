package com.example.base.test.enums;

import com.example.base.learn.enums.EnumProperties;
import com.example.base.learn.enums.NoValueEnum;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;

/**
 * Created  on 2022/7/1 15:15:19
 *
 * @author zl
 */
public class EnumPropertiesTest {

    @Test
    public void propertiesGetTest() {
        System.out.println(EnumProperties.MAN.getDesc());
    }

    @Test
    @DisplayName("枚举反射测试")
    public void enumsReflectTest() {
        var value = "MAN";
        var clazz = EnumProperties.class;
        if (clazz.isEnum()) {
            var enumConstants = clazz.getEnumConstants();
            Arrays.stream(enumConstants).filter(ep -> ep.name().equals(value)).forEach(ep -> System.out.println(ep.name()));
        }

    }

    @Test
    @DisplayName("无参数枚举测试")
    public void testNoValueEnum() {
        var noValueEnumClass = NoValueEnum.class;
        System.out.println(Arrays.toString(noValueEnumClass.getEnumConstants()));
    }
}
