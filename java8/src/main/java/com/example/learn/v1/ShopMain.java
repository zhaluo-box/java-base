package com.example.learn.v1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ShopMain {

    public static void main(String[] args) {
        Shop shop = new Shop( "BestShop" );
        long start = System.nanoTime();

        Future<Double> futurePrice = shop.getPriceAsync( "my favorite product" );

        long invocationTime = ((System.nanoTime() - start) / 1_000_000);

        System.out.println( "Invocation returned after " + invocationTime
                + " msecs" );
        // Do some more tasks, like querying other shops
        doSomethingElse();
        // while the price of the product is being calculated
        try {
            // 获取价格
            double price = futurePrice.get();
            System.out.printf( "Price is %.2f%n", price );
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException( e );
        }
        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println( "Price returned after " + retrievalTime + " msecs" );
    }

    /**
     * 模拟做一些其他的事情.
     */
    private static void doSomethingElse() {
        System.out.println( "Doing something else..." );
    }

}
