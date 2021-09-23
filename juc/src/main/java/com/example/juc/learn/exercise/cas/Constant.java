package com.example.juc.learn.exercise.cas;

import java.util.concurrent.atomic.AtomicBoolean;

public interface Constant {

    AtomicBoolean status = new AtomicBoolean(true);
}
