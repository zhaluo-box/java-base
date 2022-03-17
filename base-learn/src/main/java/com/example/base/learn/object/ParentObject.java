package com.example.base.learn.object;

import com.example.base.learn.entity.object.StaticObject;
import com.example.base.learn.entity.object.Student;

/**
 * Created  on 2022/3/17 13:13:32
 *
 * @author zl
 */
public class ParentObject {

    private static final String name = "【父类】";

    private static StaticObject staticObject = new StaticObject(name);

    static {
        System.out.println(name + " 对象的静态代码块执行");
    }

    private Student student = new Student(name + " 非静态成员变量");

    {
        System.out.println(name + " 对象的非静态代码块!");
    }

    public ParentObject() {
        System.out.println(name + " 对象的构造函数！");
    }

}
