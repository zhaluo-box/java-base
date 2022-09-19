package com.example.base.test.utils;

import com.example.base.learn.lang.reflect.SubClass;
import com.example.base.learn.utils.DefaultReflectUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Created  on 2022/9/19 14:14:38
 *
 * @author zl
 */
class DefaultReflectUtilTest {

    @Test
    @DisplayName("测试获取所有字段")
    public void getAllField() {
        var allField = DefaultReflectUtil.getAllField(SubClass.class);
        allField.forEach(field -> System.out.println(field.getName()));
    }
}
