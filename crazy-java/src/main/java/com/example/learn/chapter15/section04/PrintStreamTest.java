package com.zhaluobox.crazyjava.chapter15.section04;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class PrintStreamTest {
    public static void main(String[] args) {


        try (FileOutputStream fos = new FileOutputStream("a.txt")) {
            try (PrintStream ps = new PrintStream(fos)) {
                // 使用PrintStream执行输出
                ps.println("普通字符串");
                // 直接使用PrintStream输出对象
                ps.println(new PrintStreamTest());
                ps.println("一行白鹭上青天");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}

