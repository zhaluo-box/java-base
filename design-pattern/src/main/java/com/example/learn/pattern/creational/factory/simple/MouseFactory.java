package com.example.learn.pattern.creational.factory.simple;

import com.example.learn.pattern.creational.factory.entity.Mouse;

/**
 *
 */
public interface MouseFactory {
    enum MouseType {
        HP, DELL, OTHER
    }

    Mouse createMouse(MouseType mouseType);
}
