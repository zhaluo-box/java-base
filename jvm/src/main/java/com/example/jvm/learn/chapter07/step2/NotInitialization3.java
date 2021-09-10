package com.example.jvm.learn.chapter07.step2;

/**
 * 除了5种 不会触发类的初始化,称为被动引用
 *
 * 虚拟机参数:
 * -XX:+TraceClassLoading
 */
public class NotInitialization3 {

    public static void main(String[] args) {

        System.out.println(ConstClass.Hello_word);
    }
}
