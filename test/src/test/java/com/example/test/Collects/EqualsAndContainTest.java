package com.example.test.Collects;

import com.example.test.entity.Student;
import com.example.test.entity.User;
import org.junit.Test;

import java.util.ArrayList;

public class EqualsAndContainTest {

    @Test
    public void testEquals() {
        var student = new Student().setAge(11).setName("张三");
        var student2 = new Student().setAge(11).setName("里斯");
        var student3 = new Student().setAge(11).setName("王五");
        var student4 = new Student().setAge(11).setName("张三");
        var students = new ArrayList<Student>();

        var user = new User().setAddress("北京").setAge(11).setName("张三");
        var user2 = new User().setAddress("北京").setAge(11).setName("李四");
        var user3 = new User().setAddress("北京").setAge(11).setName("王五");

        var users = new ArrayList<User>();

        System.out.println(student.equals(user));
        System.out.println(student.equals(student4));
    }
}
