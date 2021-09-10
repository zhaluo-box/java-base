package com.example.jvm.learn.chapter07.step2;

public class SuperClass {

    /**
     * 静态代码块
     */
    static {
        System.out.println("父类 初始化 init");
    }

    /**
     * 空构造
     */
    public SuperClass(){
        System.out.println("SuperClass空构造");
    }

    // 属性

    /**
     * static关键字修饰的字段 有个特点就是伴随着类的初始化而初始化
     *  如果没有赋值则初始化的时候赋予默认值
     */
    public static  int value = 123 ;

    /**
     *  如果字段被static final 修饰 那么这个字段在编译器就把结果放入了常量池.在子类调用父类的时候父类就无需初始化
     */
 //   public static final String HAN_ZI_VALUE = "汉字";

}
