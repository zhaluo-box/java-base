package com.example.learn.pattern.structure.decoration.chapter1;

import java.math.BigDecimal;

/**
 * 浓缩咖啡类（一种具体饮料）
 */
public class Espresso extends Beverage {

    /**
     * 说明他是Espresso饮料
     */
    public Espresso() {
        description = "Espresso";
    }

    /**
     * 实现cost方法，用来返回Espresso（浓缩咖啡）的价格
     */
    @Override
    public BigDecimal cost() {
        return new BigDecimal("2.00");
    }
}
