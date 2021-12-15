package com.example.learn.pattern.creational.factory.factorymode2;

/**
 * 定义什么是人类;人类有哪些行为;
 */
public interface Human {

    //人是愉快的，会笑的，本来是想用smile表示，想了一下laugh更合适，好长时间没有大笑了；
    void laugh();

    //人类还会哭，代表痛苦
    void cry();

    //人类会说话
    void talk();
}
