package com.zhaluobox.crazyjava.chapter15.practice;

import java.io.*;

public class FIleCurrTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        final File file = new File("/aaa/cd/a.txt");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        final BufferedReader re = new BufferedReader(new FileReader(file));
        re.close();
        Thread.sleep((long) 0.5*60*1000);
        BufferedWriter buff = new BufferedWriter(new FileWriter(file));
//        buff.close();
//        for (int i = 1; i < 100; i++) {
//            BufferedWriter buff = new BufferedWriter(new FileWriter(file));
//            if(i<99){
//                buff.write("你们好啊");
//            }
//            buff.close();
//        }
    }
}
