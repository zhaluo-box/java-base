package com.example.juc.learn.exercise.sync.demo1;

import com.example.juc.learn.exercise.sync.Account;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class QuqianThread extends Thread {

    private final Account account;
    private String threadName;
    private double amt;

    private static final AtomicInteger atomicInteger = new AtomicInteger( 0 );

    public QuqianThread(String threadName, Account acc, double amt) {
        super( threadName );
        this.threadName = threadName;
        this.account = acc;
        this.amt = amt;
    }

    @Override
    public void run() {
        synchronized (account) {

            final int i = atomicInteger.addAndGet( 1 );
            final double balance = account.getBalance();
            if (balance >= amt) {
                account.setBalance( balance - amt );
                System.out.println( Thread.currentThread().getName() + " : " + i + " :" + threadName + "  取钱成功 : " + amt + "  账户余额 : " + account.getBalance() );

                try {
                    TimeUnit.SECONDS.sleep( 2 );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return;
            }
            System.out.println( Thread.currentThread().getName() + " : " + i + " :" + threadName + "  取钱余额不足!" );
        }
    }


}
