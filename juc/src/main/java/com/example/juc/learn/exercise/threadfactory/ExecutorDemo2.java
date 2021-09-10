package com.example.juc.learn.exercise.threadfactory;

import java.util.concurrent.*;

public class ExecutorDemo2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 10, 2,
                                 TimeUnit.MINUTES, new ArrayBlockingQueue<>(100), new NameThreadFactory("ex-thread"));

        MyCallable myCallable = new MyCallable();
        MyCallable myCallable2 = new MyCallable();

        Future<Integer> submit = pool.submit(myCallable);
        Future<Integer> submit1 = pool.submit(myCallable2);
        System.out.println(submit.get());
        System.out.println(submit1.get());

        pool.shutdown();
    }
}
