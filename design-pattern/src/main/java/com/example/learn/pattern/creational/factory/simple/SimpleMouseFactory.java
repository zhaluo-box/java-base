package com.example.learn.pattern.creational.factory.simple;

import com.example.learn.pattern.creational.factory.entity.DELLMouse;
import com.example.learn.pattern.creational.factory.entity.HPMouse;
import com.example.learn.pattern.creational.factory.entity.Mouse;
import com.example.learn.pattern.creational.factory.entity.OtherMouse;

/**
 *
 */
public class SimpleMouseFactory implements MouseFactory {

    @Override
    public Mouse createMouse(MouseType mouseType) {

        Mouse mouse;
        switch (mouseType) {
        case HP:
            mouse = new HPMouse();
            break;
        case DELL:
            mouse = new DELLMouse();
            break;
        case OTHER:
            mouse = new OtherMouse();
            break;
        default:
            throw new IllegalStateException("Unexpected value: " + mouseType);
        }
        return mouse;

    }

    public static void main(String[] args) {

    }
}
