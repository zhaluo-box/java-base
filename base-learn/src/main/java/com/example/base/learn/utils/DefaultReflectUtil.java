package com.example.base.learn.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created  on 2022/9/19 13:13:33
 *
 * @author zl
 */
public final class DefaultReflectUtil {

    /**
     * 获取所有字段, 包含 父类 超父类
     */
    public static List<Field> getAllField(Class<?> clazz) {

        List<Field> fields = new ArrayList<>();
        while (clazz != null) {
            fields.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
        }
        return fields;
    }
    
}
