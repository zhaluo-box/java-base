package com.example.learn.pattern;

import com.example.learn.pattern.builder.demo1.DS1;
import com.example.learn.pattern.builder.demo1.DataConnection;
import com.example.learn.pattern.builder.demo1.DataConnectionBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created  on 2023/8/15 23:23:07
 *
 * @author zl
 */
public class DemoTest {

    /**
     * 测试方法
     *
     * @param args
     */
    public static void main(String[] args) {

        //        // 逐个set
        //        var dataConnection = new DataConnection();
        //        dataConnection.setDriver("com.mysql.driver");
        //        dataConnection.setHost("localhost");
        //        dataConnection.setPort(3306);
        //        dataConnection.setUsername("root");
        //        dataConnection.setPassword("123456");
        //
        //        System.out.println("dataConnection = " + dataConnection);
        //        System.out.println("如果你属性太多，会漏掉关键信息，导致你对象，在后续使用的时候，造成一些错误");
        //
        //        // 全参数构造
        //        var dataConnection1 = new DataConnection("com.mysql.driver", "root", 3306, "123456", "localhost");
        //        // soutv 快捷方式
        //        System.out.println("dataConnection1 = " + dataConnection1);
        //        System.out.println("由于属性太多，在构造器里面，如果位置顺序搞混， 导致你对象，在后续无法使用，无法正常工作");

        // builder 模式构建

        DS1 connection = new DataConnectionBuilder().driver("com.mysql.driver")
                                                    .setHost("localhost")
                                                    .setPort(3306)
                                                    .setUsername("root")
                                                    .setPassword("123456")
                                                    .build();
        System.out.println("connection = " + connection.getHost());
        System.out.println("connection = " + connection.getDriver());
        System.out.println("connection = " + connection.getUsername());
        System.out.println("connection = " + connection.getPort());

        System.out.println("connection.getClass() = " + connection.getClass());

        List<String> list = new ArrayList<>();
        DS1 ds = new DataConnection();
    }
}
