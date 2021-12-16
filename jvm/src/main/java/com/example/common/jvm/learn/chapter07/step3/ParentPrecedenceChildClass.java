package com.example.common.jvm.learn.chapter07.step3;


class Parent{

     static int i = 1;

    static {
        i = 30;
        System.out.println("父类静态变量初始化");
    }
}

class Child extends  Parent{

     static int j = 0;
     static {
         j = 100;
         System.out.println("子类静态变量初始化");
    }
}

/**
 * 演示父类静态语句块优先于子类静态语句块变量赋值
 */
public class ParentPrecedenceChildClass {

    public static void main(String[] args) {
        final Child child = new Child();
    }
}
