package com.example.learn.pattern.builder.source;

public class ConcreteProduct extends Builder {

    private Product product = new Product();

    @Override
    public void setPart(Object some) {
        product.setSome(  some );
    }

    @Override
    public Product buildProduct() {
        return product;
    }
}
