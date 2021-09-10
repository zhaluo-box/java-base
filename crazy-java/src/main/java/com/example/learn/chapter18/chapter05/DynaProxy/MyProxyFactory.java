package com.zhaluobox.crazyjava.chapter18.chapter18_05_使用反射生成JDK动态代理.DynaProxy;

import java.lang.reflect.*;

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

/**
 * 代理工厂.
 */
public class MyProxyFactory {

    /**
     * 为指定target生成动态代理对象
     */
    public static Object getProxy(Object target) throws Exception {

        // 创建一个MyInvokationHandler对象
        MyInvokationHandler handler = new MyInvokationHandler();
        // 为MyInvokationHandler设置target对象
        handler.setTarget(target);
        // 创建、并返回一个动态代理
        /*
            参数1 : 类加载器
            参数2 : 类的父接口
            参数3 : handle  调用invoke 方法 真正意义上实现方法的调用.
            前两个参数的作用只是通过 类加载器和父类接口把类加载到内存中[ps: 这是我猜测的]
         */
        return Proxy.newProxyInstance(target.getClass().getClassLoader()
                , target.getClass().getInterfaces(), handler);
    }
}

