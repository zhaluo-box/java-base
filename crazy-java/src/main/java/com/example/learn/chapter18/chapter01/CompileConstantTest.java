package com.zhaluobox.crazyjava.第18章类加载机制与反射.chapter18_01_类的加载_连接和初始化;

/**
 * 对于final 修饰的变量 可以理解为 宏变量  ==> Java编译器,在编译的时候就会将 除了该变量的地方直接替换
 */
class MyTest {
    static {
        System.out.println("静态初始化块...");
    }

    // 使用一个字符串直接量为static final的类变量赋值
    static final String compileConstant = "疯狂Java讲义";
}

public class CompileConstantTest {
    public static void main(String[] args) {
        // 访问、输出MyTest中的compileConstant类变量
        System.out.println(MyTest.compileConstant);   // ①
    }
}
