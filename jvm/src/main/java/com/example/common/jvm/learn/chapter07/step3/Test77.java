package com.example.common.jvm.learn.chapter07.step3;

/**
 * 模拟多线程类变量初始化-阻塞情况
 */
public class Test77 {

    static class DeadLoopClass {
        static {
            if (true) {
                System.out.println( Thread.currentThread().getName() + " init DeadLoopClass" );
                while (true) {

                }
            }
        }
    }

    public static void main(String[] args) {

            Runnable script =()->{
                System.out.println( Thread.currentThread() + "Start");
                DeadLoopClass dlc = new DeadLoopClass();
                System.out.println( Thread.currentThread() + "run over");
            };

            new Thread( script ).start();
            new Thread( script ).start();

    }
}
