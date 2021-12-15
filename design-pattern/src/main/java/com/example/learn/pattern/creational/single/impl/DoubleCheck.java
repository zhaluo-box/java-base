package com.example.learn.pattern.creational.single.impl;

/**
 * 双重检查
 * 网上有人说，这种实现方式有些问题。因为指令重排序，可能会导致 IdGenerator 对象被 new 出来，并且赋值给 instance 之后，
 * 还没来得及初始化（执行构造函数中的代码逻辑），就被另一个线程使用了
 * <link>https://blog.csdn.net/u013179982/article/details/105111645/</link>
 * 1.分配对象的内存空间
 * 2.初始化对象
 * 3.设置instance指向刚分配的内存地址
 * 按照代码应该是1-->2-->3  但是指令重排 可能会变成 1-->3-->2
 * 导致空指针的情况
 */
public class DoubleCheck {

    private static volatile DoubleCheck instance; //volatile  禁止指令重排

    private DoubleCheck() {
    }

    public static DoubleCheck getInstance() {
        if (instance == null) {
            synchronized (DoubleCheck.class) { // 类级别锁
                if (null == instance) {
                    instance = new DoubleCheck();
                }
            }
        }
        return instance;
    }
}
