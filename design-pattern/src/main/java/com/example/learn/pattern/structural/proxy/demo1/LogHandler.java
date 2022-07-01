package com.example.learn.pattern.structural.proxy.demo1;

import lombok.AllArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created  on 2022/6/2 10:10:37
 *
 * @author zl
 */
@AllArgsConstructor
public class LogHandler implements InvocationHandler {

    /**
     * 被代理的目标对象
     */
    private Object target;

    /**
     * 返回第一个参数proxy 测试方法的返回结果
     *
     * @param proxy  生成的代理对象
     * @param method 代理的方法
     * @param args   方法的参数
     * @return proxy
     * @throws Throwable 可能抛出的异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("第一个参数proxy ： " + proxy.getClass().getSimpleName());
        System.out.println("方式是哪个类声明的： " + method.getDeclaringClass());
        System.out.println("方法的参数: " + Arrays.toString(args));
        
        method.invoke(this.target, args);

        return proxy;
    }

}
