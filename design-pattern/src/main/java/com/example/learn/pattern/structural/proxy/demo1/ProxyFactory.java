package com.example.learn.pattern.structural.proxy.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 代理模式 ： 代理工厂
 * Created  on 2022/6/2 09:9:39
 *
 * @author zl
 */
public class ProxyFactory {

    public static Object getProxyInstance(Object obj, InvocationHandler invocationHandler) {
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), invocationHandler);
    }
}
