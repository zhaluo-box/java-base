package com.example.learn.v1;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import static com.example.learn.Util.delay;

public class Shop {

    private final String name;
    private final Random random;

    public Shop(String name) {
        this.name = name;
        random = new Random( name.charAt( 0 ) * name.charAt( 1 ) * name.charAt( 2 ) );
    }

    /**
     * 同步阻塞方法.
     *
     * @param product 商品
     * @return 价格
     */
    public double getPrice(String product) {
        return calculatePrice( product );
    }

    /**
     * 延迟模拟.
     *
     * @param product 商品
     * @return 价格
     */
    private double calculatePrice(String product) {
        delay(); // 延迟一秒钟 模拟数据库查询的操作.
        return random.nextDouble() * product.charAt( 0 ) + product.charAt( 1 );
    }

    /**
     * 异步非阻塞的方法.
     *
     * @param product 商品
     * @return 价格
     */
    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread( () -> { // fork 一个线程 执行计算
            double price = calculatePrice( product ); // 价格被计算出
            futurePrice.complete( price );  // 使用complete 结束CompletableFuture的运行, 并设置值
        } ).start();
        return futurePrice;
    }

    public String getName() {
        return name;
    }

}
