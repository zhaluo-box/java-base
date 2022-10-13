package com.example.base.learn.lang.reflect.proxy.jdk;

import lombok.AllArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created  on 2022/9/27 11:11:59
 *
 * @author zl
 */
@AllArgsConstructor
public class CustomInvocationHandler implements InvocationHandler {

    private Object target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
