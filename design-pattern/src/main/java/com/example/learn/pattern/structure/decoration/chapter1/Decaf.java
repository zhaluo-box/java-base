package com.example.learn.pattern.structure.decoration.chapter1;

import java.math.BigDecimal;

/**
 * 低咖啡因咖啡类（一种具体的饮料）
 */
public class Decaf extends Beverage {

    /**
     * 说明他是Decaf饮料
     */
    public Decaf() {
        description = "Decaf";
    }

    @Override
    public BigDecimal cost() {
        return new BigDecimal("44.4");
    }
}
