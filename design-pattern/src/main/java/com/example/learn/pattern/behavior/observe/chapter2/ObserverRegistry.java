package com.example.learn.pattern.behavior.observe.chapter2;

import com.example.learn.pattern.behavior.observe.chapter2.annoition.Subscribe;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Observer 注册表, 大量使用反射语法, 使用JUC　copyOnWriteArraySet
 * 新的set 替换老的set, 不会影响旧的set的读取操作, 避免读写问题, 还使用加锁的方式避免读写并发冲突
 */
public class ObserverRegistry {

    private static final Map<Class<?>, CopyOnWriteArraySet<ObserverAction>> REGISTRY_TABLE = new ConcurrentHashMap<>();

    /**
     * 注册事件
     */
    public void registry(Object observer) {
        // 查询所有的事件注册
        Map<Class<?>, Collection<ObserverAction>> observerActions = findAllObserverActions(observer);

        for (Map.Entry<Class<?>, Collection<ObserverAction>> entry : observerActions.entrySet()) {
            // 获取事件类型
            Class<?> eventType = entry.getKey();
            Collection<ObserverAction> eventActions = entry.getValue();
            // 获取注册事件表
            CopyOnWriteArraySet<ObserverAction> registeredEventAction = REGISTRY_TABLE.get(eventType);
            // 如果注册事件表为空
            if (registeredEventAction == null) {
                // 放入一个空的事件, 并获取
                REGISTRY_TABLE.putIfAbsent(eventType, new CopyOnWriteArraySet<>());
                registeredEventAction = REGISTRY_TABLE.get(eventType);
            }
            // 将事件注册到事件表里面
            registeredEventAction.addAll(eventActions);
        }

    }

    /**
     * 查询所有匹配的事件操作
     */
    public List<ObserverAction> getMatchedObserverAction(Object event) {
        List<ObserverAction> matchedObserverActions = new ArrayList<>();
        Class<?> postedEventType = event.getClass();
        for (Map.Entry<Class<?>, CopyOnWriteArraySet<ObserverAction>> entry : REGISTRY_TABLE.entrySet()) {
            Class<?> eventType = entry.getKey();
            Collection<ObserverAction> eventActions = entry.getValue();
            // 如果事件类型是注册事件类型的父类或者类型相同
            if (postedEventType.isAssignableFrom(eventType)) {
                matchedObserverActions.addAll(eventActions);
            }
        }
        return matchedObserverActions;
    }

    /**
     *
     */
    private Map<Class<?>, Collection<ObserverAction>> findAllObserverActions(Object observer) {

        Map<Class<?>, Collection<ObserverAction>> observerActions = new HashMap<>();
        Class<?> clazz = observer.getClass();

        // 获取所有注解方法并遍历
        for (Method method : getAnnotatedMethods(clazz)) {
            // 获取所有注解方法的参数, 参数有且仅有一个, 多余一个参数的方法已经在上一步做了判断
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?> eventType = parameterTypes[0];

            // 如果不包含当前事件类型的, 则直接添加
            if (!observerActions.containsKey(eventType)) {
                observerActions.put(eventType, new ArrayList<>());
            }
            // 向事件注册表添加新的 事件处理方法
            observerActions.get(eventType).add(new ObserverAction(observer, method));
        }
        return observerActions;
    }

    /**
     * 获取所有注解方法, 方法参数只支持一个
     */
    private List<Method> getAnnotatedMethods(Class<?> clazz) {

        List<Method> annotatedMethods = new ArrayList<>();
        // 查询所有声明的方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            // 查询所有带有指定注解的方法
            if (method.isAnnotationPresent(Subscribe.class)) {
                // 验证注解方法是否只有一个参数, 目前只支持一个参数的方法
                if (method.getParameterTypes().length != 1) {
                    throw new RuntimeException("目前事件处理方法只支持一个参数!");
                }
                annotatedMethods.add(method);
            }
        }
        return annotatedMethods;
    }

}
