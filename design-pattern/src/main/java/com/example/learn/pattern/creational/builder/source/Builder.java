package com.example.learn.pattern.creational.builder.source;

/**
 * 建造者.
 */
public abstract class Builder {

    //设置产品的不同部分，以获得不同的产品
    public abstract void setPart( Object o);

    //建造产品
    public abstract Product buildProduct();
}
