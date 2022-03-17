package com.example.base.learn.entity.object;

/**
 * 用于类
 * Created  on 2022/3/17 11:11:52
 *
 * @author zl
 */
public class Student {

    private String name;

    public Student() {
        System.out.println("非静态成员变量创建！");
    }

    public Student(String name) {
        this.name = name;
        System.out.println(name + " 创建！");
    }
}
