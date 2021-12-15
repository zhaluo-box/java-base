package com.example.learn.pattern.creational.factory.entity;

/**
 *
 */
public interface Mouse {

    enum ClickType {
        SINGLE, DOUBLE
    }

    String getName();

    void click();

    void doubleClick();

    default String print(ClickType clickType) {

        var message = "";
        switch (clickType) {
        case DOUBLE:
            message = "双击鼠标";
            break;
        case SINGLE:
            message = "单击鼠标";
            break;
        default:
            message = "滚动滑轮";
        }

        return message;
    }
}
