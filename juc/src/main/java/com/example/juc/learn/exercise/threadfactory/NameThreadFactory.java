package com.example.juc.learn.exercise.threadfactory;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NameThreadFactory implements ThreadFactory {

    private String name;

    private AtomicInteger tag = new AtomicInteger(0 );

    public NameThreadFactory(String name) {
        super();
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {
        final Thread thread = new Thread( r );
        thread.setName( name +"-"+tag.getAndIncrement());
        return thread;
    }

}
