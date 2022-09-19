package com.example.learn.demo;

import java.util.concurrent.*;

public class CompletableFutureDemo2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        comFutureTest2();
    }

    private static void comFutureTest() {
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.submit(() -> {
            System.out.println("executorService 是否为守护线程 :" + Thread.currentThread().isDaemon());
            return null;
        });

        final CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("this is lambda supplyAsync");
            System.out.println("supplyAsync 是否为守护线程 " + Thread.currentThread().isDaemon());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("this lambda is executed by forkJoinPool");
            return "result1";
        });

        final CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("this is task with executor");
            System.out.println("supplyAsync 使用executorService 时是否为守护线程 : " + Thread.currentThread().isDaemon());
            return "result2";
        }, executorService);

        completableFuture.join();
        future.join();

        //        System.out.println( completableFuture.get() );
        //        System.out.println( future.get() );
        executorService.shutdown();
    }

    public static void comFutureTest2() throws ExecutionException, InterruptedException {
        final CompletableFuture<String> futureOne = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("futureOne InterruptedException");
            }
            return "futureOneResult";
        });
        final CompletableFuture<String> futureTwo = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                System.out.println("futureTwo InterruptedException");
            }
            return "futureTwoResult";
        });
        CompletableFuture future = CompletableFuture.anyOf(futureOne, futureTwo);
        System.out.println(future.get());
        //        CompletableFuture completableFuture = CompletableFuture.anyOf(futureOne, futureTwo);
        //        System.out.println(completableFuture.get());
    }
}
