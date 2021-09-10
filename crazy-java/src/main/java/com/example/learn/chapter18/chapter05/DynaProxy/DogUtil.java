package com.zhaluobox.crazyjava.chapter18.chapter18_05_使用反射生成JDK动态代理.DynaProxy;


/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.come
 * @version 1.0
 */

/**
 * dog 工具类 实现代理增强
 */
public class DogUtil {
    // 第一个拦截器方法
    public void method1() {
        System.out.println("代理增强   开始 ---");
//        System.out.println("=====模拟第一个通用方法=====");
    }

    // 第二个拦截器方法
    public void method2() {
        System.out.println("代理增强    结束 ---");
//        System.out.println("=====模拟通用方法二=====");
    }
}
