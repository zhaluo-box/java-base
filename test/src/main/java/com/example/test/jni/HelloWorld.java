package com.example.test.jni;

/**
 * Java 调用JDI
 * Created  on 2021/9/26 09:9:09
 */
public class HelloWorld {

    public native void printHello();

    static {
        System.loadLibrary("HelloWorld");//加载生成的dll文件

    }

    public static void main(String[] args) {
        new HelloWorld().printHello();
    }
}
