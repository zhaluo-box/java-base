package com.zhaluobox.crazyjava.第18章类加载机制与反射.chapter18_01_类的加载_连接和初始化;

/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class Test {
    static int b;

    static {
        // 使用静态初始化块为变量b指定出初始值
        b = 6;
        System.out.println("----------" + b);
    }

    // 声明变量a时指定初始值
    static int a = 5;

    static int c;

    public static void main(String[] args) {
        System.out.println(Test.b);
        System.out.println(Test.a);
        System.out.println(Test.c);
    }
}
