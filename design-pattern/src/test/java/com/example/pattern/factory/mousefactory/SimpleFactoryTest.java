package com.example.pattern.factory.mousefactory;

import com.example.learn.pattern.creational.factory.simple.MouseFactory;
import com.example.learn.pattern.creational.factory.simple.SimpleMouseFactory;
import org.junit.Test;

/**
 *
 */
public class SimpleFactoryTest {

    private static final MouseFactory MOUSE_FACTORY = new SimpleMouseFactory();

    @Test
    public void createTest() {
        MOUSE_FACTORY.createMouse(MouseFactory.MouseType.HP).click();
    }

}
