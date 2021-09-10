package com.example.learn.v1;

import java.util.List;
import java.util.function.Supplier;

public class BestPriceFinderMain {

    private static BestPriceFinder bestPriceFinder = new BestPriceFinder();

    public static void main(String[] args) {
        // 传统顺序的执行
        execute( "sequential", () -> bestPriceFinder.findPricesSequential( "myPhone27S" ) );
        // 并行执行
        execute( "parallel", () -> bestPriceFinder.findPricesParallel( "myPhone27S" ) );
        // 采用completableFuture 优化
        execute( "composed CompletableFuture", () -> bestPriceFinder.findPricesFuture( "myPhone27S" ) );
        // 采用completableFuture 优化1
        execute( "combined USD CompletableFuture", () -> bestPriceFinder.findPricesInUSD( "myPhone27S" ) );
        // 采用completableFuture 优化2
        execute( "combined USD CompletableFuture v2", () -> bestPriceFinder.findPricesInUSD2( "myPhone27S" ) );
        // 采用completableFuture 优化3
        execute( "combined USD CompletableFuture v3", () -> bestPriceFinder.findPricesInUSD3( "myPhone27S" ) );
    }

    private static void execute(String msg, Supplier<List<String>> s) {
        long start = System.nanoTime();
        System.out.println( s.get() ); // 获取结果.
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println( msg + " done in " + duration + " msecs" );
    }
}
