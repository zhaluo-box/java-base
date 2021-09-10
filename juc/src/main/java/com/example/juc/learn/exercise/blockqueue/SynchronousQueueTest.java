package com.example.juc.learn.exercise.blockqueue;

import java.util.Random;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 不存储元素的阻塞队列 , cachePool  使用的就是这个阻塞队列.
 * <p>
 * 消费者与生产者模拟演示.
 */
public class SynchronousQueueTest {

    public static void main(String[] args) {
//        SynchronousQueue<Integer> queue = new SynchronousQueue<Integer>();
//
//        new Product( queue ).start();
//        new Customer( queue ).start();

        SynchronousQueue<String> queue2=new SynchronousQueue<>();
        // TODO Auto-generated method stub
        for(int i=0;i<5;i++)
            new Thread(new ThreadProducer(queue2)).start();
        for(int i=0;i<5;i++)
            new Thread(new ThreadConsumer(queue2)).start();
    }


    /**
     * 生产者线程 extends Thread
     */
    static class Product extends Thread {
        SynchronousQueue<Integer> queue;

        public Product(SynchronousQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                int rand = new Random().nextInt( 1000 );
                System.out.println( "生产了一个产品：" + rand );
                System.out.println( "等待三秒后运送出去..." );
                try {
                    TimeUnit.SECONDS.sleep( 3 );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    queue.put( rand );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // isEmpty() 永远为true
                System.out.println( queue.isEmpty() );
            }
        }
    }

    /**
     * 消费者
     * extends Thread.
     */
    static class Customer extends Thread {
        SynchronousQueue<Integer> queue;

        public Customer(SynchronousQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println( "消费了一个产品:" + queue.take() );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println( "------------------------------------------" );
            }
        }
    }

    static class ThreadProducer implements Runnable {
        ThreadProducer(SynchronousQueue<String> queue) {
            this.queue = queue;
        }

        SynchronousQueue<String> queue;
        static int cnt = 0;

        public void run() {
            String name = "";
            int val = 0;
            Random random = new Random( System.currentTimeMillis() );
            for (int i = 0; i < 2; i++) {

                cnt = (cnt + 1) & 0xFFFFFFFF;

                try {
                    val = random.nextInt() % 15;
                    if (val < 5) {
                        name = "offer name:" + cnt;
                        queue.offer( name );
                    } else if (val < 10) {
                        name = "put name:" + cnt;
                        queue.put( name );
                    } else {
                        name = "offer wait time and name:" + cnt;
                        queue.offer( name, 1000, TimeUnit.MILLISECONDS );
                    }
                    Thread.sleep( 1 );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ThreadConsumer implements Runnable {
        ThreadConsumer(SynchronousQueue<String> queue) {
            this.queue = queue;
        }

        SynchronousQueue<String> queue;

        public void run() {
            String name;
            for (int i = 0; i < 2; i++) {
                try {
                    name = queue.take();
                    System.out.println( "take " + name );
                    Thread.sleep( 1 );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
