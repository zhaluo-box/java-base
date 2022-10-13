package com.example.base.learn.lang.reflect.proxy.jdk;

import java.lang.reflect.InvocationHandler;

/**
 * Created  on 2022/9/27 12:12:02
 *
 * @author zl
 */
public final class CustomJDKProxyFactory {

    public static Object getProxy(Object obj) {

        return null;
    }

    private InvocationHandler getInvocationHandler(Object target) {
        return new CustomInvocationHandler(target);
    }
}
