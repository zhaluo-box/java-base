package com.example.learn.pattern.creational.builder;

import java.util.List;

public class BenzBuilder  extends CarBuilder{
    private CarModel model  =  new BenzModel( "奔驰" );


    @Override
    public void setSequence(List<String> sequenceList) {
        model.setSequence( sequenceList );
    }

    @Override
    public CarModel getCarModel() {
        return this.model;
    }
}
