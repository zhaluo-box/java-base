package com.example.learn.pattern.creational.single.log;

import lombok.SneakyThrows;

import java.io.FileWriter;

public class Logger {
    private FileWriter fileWriter;

    @SneakyThrows
    public Logger() {
        fileWriter = new FileWriter("", true);
    }

    @SneakyThrows
    public void log(String message) {
        synchronized (Logger.class) {
            fileWriter.write(message);
        }
    }
}
