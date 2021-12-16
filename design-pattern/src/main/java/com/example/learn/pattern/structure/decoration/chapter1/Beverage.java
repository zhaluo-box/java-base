package com.example.learn.pattern.structure.decoration.chapter1;

import java.math.BigDecimal;

/**
 * 饮料抽象类
 */
public abstract class Beverage {

    String description = "unKnow Beverage";

    /**
     * cost方法是用来返回饮料的价钱（需在具体类中自己实现）
     */
    public abstract BigDecimal cost();

    public String getDescription() {
        return description;
    }
}
