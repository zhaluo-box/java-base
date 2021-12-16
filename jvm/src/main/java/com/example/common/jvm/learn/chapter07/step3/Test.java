package com.example.common.jvm.learn.chapter07.step3;

public class Test {

    static{
        i =0;  //变量赋值可以正常通过
        // illegal forward reference 非法向前引用 编译报错
        // System.out.println(i);
    }

    static int i = 1;
}
