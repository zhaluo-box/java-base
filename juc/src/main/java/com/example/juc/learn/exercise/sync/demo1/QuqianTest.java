package com.example.juc.learn.exercise.sync.demo1;

import com.example.juc.learn.exercise.sync.Account;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuqianTest {

    public static void main(String[] args) throws InterruptedException {
        final Account account = new Account("66688", 9998.88 );
        final QuqianThread thread1 = new QuqianThread( "甲", account, 1288.8 );
        final QuqianThread thread2 = new QuqianThread( "乙", account, 288.8 );
        final QuqianThread thread3 = new QuqianThread( "丙", account, 688.8 );


        final ExecutorService executorService = Executors.newFixedThreadPool( 5 );
        for (int i = 0; i < 50; i++) {
            int x = i % 3;

            //                      executorService.submit( thread1 );

            if (x == 1) {
                executorService.submit( thread1 );
            }

            if (x == 2) {
                executorService.submit( thread2 );
            }

            if (x == 0) {
                executorService.submit( thread3 );
            }


        }

       // TimeUnit.SECONDS.sleep( 20 );
//        executorService.shutdownNow();
        executorService.shutdown();
    }
}
