package com.example.learn.chapter18.chapter05.DynaProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

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

public class MyInvokationHandler<T> implements InvocationHandler {
    // 需要被代理的对象 类型位置 用object
    private T target;

    /**
     * 构造器 传入目标对象.
     *
     * @param target 目标对象.
     */
    public MyInvokationHandler(T target) {
        this.target = target;
    }

    public MyInvokationHandler() {

    }

    /**
     * 方便自由切换目标对象
     *
     * @param target 目标对象.
     */
    public void setTarget(T target) {
        this.target = target;
    }

    // 执行动态代理对象的所有方法时，都会被替换成执行如下的invoke方法
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
        // 创建一个目标对象.
        DogUtil du = new DogUtil();
        // 执行DogUtil对象中的method1。
        du.method1();
        // 以target作为主调来执行method方法
        Object result = method.invoke(target, args);
        // 执行DogUtil对象中的method2。
        System.out.println(proxy.getClass().getName());
        du.method2();
        return result;
    }
}

