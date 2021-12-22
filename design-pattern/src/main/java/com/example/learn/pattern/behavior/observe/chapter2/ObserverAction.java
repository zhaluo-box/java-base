package com.example.learn.pattern.behavior.observe.chapter2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * 注解Subscribe 的方法
 */
public class ObserverAction {

    /**
     * 观察者类
     */
    private Object target;

    /**
     * 方法
     */
    private Method method;

    public ObserverAction(Object target, Method method) {
        Objects.requireNonNull(target, () -> "target 不能为空!");
        this.target = target;
        this.method = method;
    }

    public void execute(Object event) {
        try {
            method.invoke(target, event);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
