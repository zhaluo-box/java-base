package com.example.learn.pattern.behavior.observe.chapter1;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 *
 */
@Data
@Accessors(chain = true)
public class Message<T> {

    private T data;

    private String info;

}
