package com.example.learn.pattern.behavior.observe.chapter2.annoition;

import com.example.learn.pattern.behavior.observe.chapter2.EventBus;

import java.util.concurrent.Executor;

/**
 * 异步EventBus
 */
public class AsyncEventBus extends EventBus {

    public AsyncEventBus(Executor executor) {
        super(executor);
    }
}
