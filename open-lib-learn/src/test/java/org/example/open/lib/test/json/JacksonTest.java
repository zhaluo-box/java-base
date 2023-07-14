package org.example.open.lib.test.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.common.entity.Course;
import org.example.common.entity.Student;
import org.example.open.lib.learn.util.JsonUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Created  on 2023/7/13 15:15:56
 *
 * @author zl
 */
public class JacksonTest {

    @Test
    @DisplayName("测试嵌套对象序列化")
    public void testNestObjSerializer() {

        // 准备数据

        var course1 = new Course().setName("语文").setTeacherName("张三");
        var course2 = new Course().setName("数学").setTeacherName("王五");
        var course3 = new Course().setName("英语").setTeacherName("李四");

        List<Course> courses = List.of(course1, course2, course3);

        var student = new Student().setName("小明").setAddress("北京").setAge(12).setCourseList(courses);

        // 准备objectMapper对象
        var objectMapper = new ObjectMapper();

        // json
        var json = "";
        try {
            json = objectMapper.writeValueAsString(student);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println("json = " + json);

        var deserializeObj = JsonUtil.toObject(json, Student.class);
        System.out.println("deserializeObj = " + deserializeObj);

    }

}
