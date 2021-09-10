package com.example.learn.pattern.proxyModel.proxymodel2;

import java.lang.reflect.Proxy;

public class GrilFactoryProxy {

    // 为指定target生成动态代理对象
    public static Object getProxy(Object target) throws Exception{

        MyInvoke myInvoke = new MyInvoke();
        myInvoke.setTarget(target);

        // 创建、并返回一个动态代理
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),myInvoke);
    }
}
