package com.example.learn.pattern.creational.single.log;

public class OrderController {

    private Logger log = new Logger();

    public void create(String order) {
        log.log(order);
    }

}
