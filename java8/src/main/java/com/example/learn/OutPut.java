package com.example.learn;

/**
 * 接口的学习
 * 主要是java 8 的新特性
 */
public interface OutPut {

    /**
     * 成员变量[常量]
     */
    int MAX_CACHE_LINE = 50;

    /**
     * 普通方法
     */
    void out();

    /**
     * java 8 新特性
     * 默认方法-需要使用default修饰
     */
    default void run() {
        System.out.println("接口抽取并定义了多个实现类的规范[共性]");
    }

    /**
     * java 8 新特性
     * 类方法-需要使用static修饰
     */
    static void describe() {
        System.out.println("类方法.伴随着类的加载而加载.普通方法.只能被创建实例而分配内存空间");
    }

}
