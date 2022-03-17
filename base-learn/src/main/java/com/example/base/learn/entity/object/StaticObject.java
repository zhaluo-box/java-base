package com.example.base.learn.entity.object;

/**
 * Created  on 2022/3/17 11:11:47
 *
 * @author zl
 */
public class StaticObject {

    private String name;

    public StaticObject() {
        System.out.println("静态成员变量创建成功");
    }

    public StaticObject(String name) {
        this.name = name;
        System.out.println(this.name + " 静态成员变量创建成功");
    }
}
