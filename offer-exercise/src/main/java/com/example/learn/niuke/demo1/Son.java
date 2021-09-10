package com.example.learn.niuke.demo1;

/**
 * @version ORAS v1.0
 * @author wang mingzhe, 2020年12月02日
 */

/**
 * 子类
 *
 * @author 扎罗
 * @Date 2020-12-2 10:25
 * @version 1.0.0
 */
public class Son  extends Base{

    public void method(){
        System.out.println("son method;");
    }

    public  void  methodB(){
        System.out.println("son methodB;");

    }

    public static void main(String[] args) {
        Base base = new Son();
        base.method();
    }
}
