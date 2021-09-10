package com.example.learn.demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo {

    public static void main(String[] args) {
        CompletableFuture<String> doPost = new CompletableFuture<>();

        Runnable r = () -> {
            try {

                final String post = post();
                //            System.out.println( post );
                doPost.complete( post );
            }catch (Exception e){
                doPost.completeExceptionally( e );
            }
        };
        new Thread( r ).start();
        System.out.println("----");
        try {
            TimeUnit.SECONDS.sleep( 1 );
            System.out.println( doPost.get() );// get 阻塞式的调用返回结果
            System.out.println( "------结果返回-------" );
            TimeUnit.SECONDS.sleep( 1 );
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

    public static String post() {
        try {
            TimeUnit.SECONDS.sleep( 1 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "www.baidu.com response success!";
    }
}
