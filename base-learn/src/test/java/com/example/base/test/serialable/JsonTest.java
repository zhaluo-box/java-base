package com.example.base.test.serialable;

import cn.hutool.json.JSONUtil;
import com.example.base.learn.entity.object.Student;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.lang.reflect.InvocationTargetException;

/**
 * Created  on 2023/3/21 17:17:59
 *
 * @author zl
 */
public class JsonTest {

    @Test
    @DisplayName("演示json对象多次转换")
    public void testDes() throws InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {

        var jsonTestClass = JsonTest.class;

        var methods = jsonTestClass.getMethods();
        var method = methods[0];

        var parameterType = method.getGenericParameterTypes()[0];

        var jsonTest = jsonTestClass.newInstance();
        method.setAccessible(true);
        var vo = new ApproveVO<Object>().setName("zhang").setData(new Student("张三"));

        var str = JSONUtil.toJsonStr(vo);
        Object o = JSONUtil.toBean(str, Class.forName(parameterType.getTypeName()));

        method.invoke(jsonTest, o);

    }

    @Data
    @ToString
    @Accessors(chain = true)
    public static class ApproveVO<T> {

        private String name;

        private T data;

    }

    public void approveMethod(ApproveVO<Student> data) {

        System.out.println(data.getData().getName());
    }

}
