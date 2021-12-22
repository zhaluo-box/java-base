package com.example.learn.pattern.behavior.observe.chapter2;

import java.util.concurrent.ExecutorService;

/**
 * 异步EventBus
 */
public class AsyncEventBus extends EventBus {

    public AsyncEventBus(ExecutorService executor) {
        super(executor);
    }
}
