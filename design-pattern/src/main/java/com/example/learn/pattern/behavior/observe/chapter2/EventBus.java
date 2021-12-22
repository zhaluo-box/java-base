package com.example.learn.pattern.behavior.observe.chapter2;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * 事件总线
 */
public class EventBus {

    private ExecutorService executor;

    private ObserverRegistry registry = new ObserverRegistry();

    public EventBus() {
    }

    protected EventBus(ExecutorService executor) {
        this.executor = executor;
    }

    /**
     * 注册事件
     */
    public void register(Object object) {
        registry.registry(object);
    }

    /**
     * 发送事件
     */
    public void post(Object event) {
        // 获取所有匹配的注册事件
        List<ObserverAction> observerActions = registry.getMatchedObserverAction(event);
        observerActions.forEach(observerAction -> {
            if (executor == null) {
                observerAction.execute(event);
            } else {
                Future<?> future = executor.submit(() -> {
                    System.out.println("异步处理事件");
                    observerAction.execute(event);
                });
                try {
                    future.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
