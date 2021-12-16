package com.example.learn.pattern.structure.decoration.chapter1;

import java.math.BigDecimal;

/**
 *深培咖啡
 */
public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "深培咖啡";
    }

    @Override
    public BigDecimal cost() {
        return new BigDecimal("33.33");
    }

}
