package com.example.learn.pattern.proxyModel.proxymodel2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvoke implements InvocationHandler {

    // 需要被代理的对象
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception {

        BeautifulGrillService.perService();
        final Object result = method.invoke(target, args);
        BeautifulGrillService.afterService();
        return result;
    }
}
