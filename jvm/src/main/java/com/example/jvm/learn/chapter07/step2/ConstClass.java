package com.example.jvm.learn.chapter07.step2;

/**
 * 被动引用类字段演示三.
 * 常量在编译阶段会存入调用类的常量池,本质上并没有直接引用到定义常量的类,因此不会触发定义常量的类的初始化.
 */
public class ConstClass {

    static{
        System.out.println("ConstClass init !");
    }

    public static final String  Hello_word = "helloWord";
}
