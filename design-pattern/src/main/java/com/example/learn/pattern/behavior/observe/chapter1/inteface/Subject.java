package com.example.learn.pattern.behavior.observe.chapter1.inteface;

import com.example.learn.pattern.behavior.observe.chapter1.Message;

/**
 *
 */
public interface Subject {

    // 注册
    void registerObserver(Observer observer);

    // 移除
    void removeObserver(Observer observer);

    // 通知
    void noticeObserver(Message message);

}
