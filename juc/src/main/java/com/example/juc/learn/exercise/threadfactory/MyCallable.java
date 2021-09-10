package com.example.juc.learn.exercise.threadfactory;

import java.util.concurrent.Callable;

public class MyCallable<Integer> implements Callable<java.lang.Integer> {

    private int i = 10;

    @Override
    public java.lang.Integer call() throws Exception {

        int sum = 0;
        for (int j = 0; j < i; j++) {

            sum += j;
            System.out.println(Thread.currentThread().getName() + " : " + j);
        }
        return sum;
    }
}
