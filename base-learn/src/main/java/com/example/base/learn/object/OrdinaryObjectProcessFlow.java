package com.example.base.learn.object;

import com.example.base.learn.entity.object.StaticObject;
import com.example.base.learn.entity.object.Student;

/**
 * 普通对象执行的流程
 * Created  on 2022/3/17 11:11:49
 *
 * @author zl
 */
public class OrdinaryObjectProcessFlow {

    private static final String name = "普通";

    private static StaticObject staticObject = new StaticObject(name);

    static {
        System.out.println(name + " 对象的静态代码块执行");
    }

    private Student student = new Student("非静态成员变量");

    {
        System.out.println(name + " 对象的非静态代码块!");
    }

    public OrdinaryObjectProcessFlow() {
        System.out.println(name + "对象的构造函数！");
    }
}
