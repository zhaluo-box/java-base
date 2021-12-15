package com.example.learn.pattern.creational.single.id;

import java.util.concurrent.atomic.AtomicLong;

/**
 *
 */
public class IdGenerator {

    private AtomicLong id = new AtomicLong(0);

    private static final IdGenerator instance = new IdGenerator();

    private IdGenerator() {
    }

    public static IdGenerator getInstance() {
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        System.out.println(IdGenerator.getInstance().getId());
    }
}
