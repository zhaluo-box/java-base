package com.example.learn.mytest;

import java.io.File;
import java.io.IOException;

public class FileCreate {

    public static void main(String[] args) throws IOException {
        final File file = new File("/ora/aaa/aaa.txt");

        if (!file.exists()) {
            final File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            if (file.createNewFile()) {
                System.out.println("文件创建成果");
            }
        }
    }
}
