package com.example.learn.pattern.builder;

import java.util.List;

public class BwmBuilder extends CarBuilder {

    private CarModel model = new BwmModel( "宝马" );

    @Override
    public void setSequence(List<String> sequenceList) {
        model.setSequence( sequenceList );
    }

    @Override
    public CarModel getCarModel() {
        return model;
    }
}
