package com.example.juc.learn.exercise.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableAction {

    public static void main(String[] args) {

        // 1. 创建Callable对象
        Callable<String> callable = new Callable<String>() {

            public String a = "";

            @Override
            public String call() throws Exception {
                synchronized (this) {
                    for (int i = 0; i < 20; i++) {
                        a = a.concat( i + " + " );
                        System.out.println( Thread.currentThread().getName() + " : " + a );
                    }
                    return a;
                }
            }
        };

        // 2. 将Callable 传给 FutureTask 对象
        final FutureTask<String> task = new FutureTask<>( callable );


        // 3. FutureTask 对象

        final Thread thread = new Thread( task, "name1" );
        thread.start();

        try {
            System.out.println( task.get() );
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}
