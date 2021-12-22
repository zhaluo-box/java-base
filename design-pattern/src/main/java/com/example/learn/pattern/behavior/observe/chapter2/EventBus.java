package com.example.learn.pattern.behavior.observe.chapter2;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * 事件总线
 */
public class EventBus {

    private Executor executor;

    private ObserverRegistry registry = new ObserverRegistry();

    public EventBus() {
    }

    protected EventBus(Executor executor) {
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
                executor.execute(() -> {
                    observerAction.execute(event);
                });
            }
        });
    }

}
