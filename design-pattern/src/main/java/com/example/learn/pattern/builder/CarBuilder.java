package com.example.learn.pattern.builder;

import java.util.List;

/**
 * 定义一个汽车建造模板
 */
public  abstract  class CarBuilder {

    abstract void setSequence(List<String> sequenceList);

    abstract CarModel getCarModel();

}
