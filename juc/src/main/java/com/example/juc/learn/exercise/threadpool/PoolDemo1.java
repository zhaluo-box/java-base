package com.example.juc.learn.exercise.threadpool;

import lombok.SneakyThrows;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池的使用
 */
public class PoolDemo1 {
    static Runnable target =  new Runnable() {
        int i = 100;

        @SneakyThrows
        @Override
        public void run() {
            synchronized (this) {
                for (int j = 0; j < 100 && i>0; j++) {
                    System.out.println(Thread.currentThread().getName() + "剩余" + i + "张");
                        Thread.sleep(1 * 1000);

                    j++;
                    i--;
                }
            }
        }
    };

    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 15, 10, TimeUnit.HOURS, new ArrayBlockingQueue<Runnable>(5));

        poolExecutor.execute(target);
        poolExecutor.execute(target);
        poolExecutor.execute(target);
        poolExecutor.execute(target);

        int activeCount = poolExecutor.getActiveCount();
        System.out.println(activeCount);
        System.out.println(poolExecutor.shutdownNow().size());

    }
}
