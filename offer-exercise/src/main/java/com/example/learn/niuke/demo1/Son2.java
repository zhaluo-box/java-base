package com.example.learn.niuke.demo1;



/**
 *编译看左边 运行看右边;
 *
 * @author 扎罗
 * @Date 2020-12-2 10:29
 * @version 1.0.0
 */
public class Son2 extends AbstractBase{

    public void method(){
        System.out.println("son method;");
    }

    public  void  methodB(){
        System.out.println("son methodB;");

    }

    public static void main(String[] args) {
        AbstractBase  base = new Son2();
        base.method();
    }
}
