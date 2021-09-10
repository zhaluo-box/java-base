package com.example.learn;

import org.junit.Test;

import java.util.regex.Pattern;

/**
 * 哈希值测试
 */
public class HashCodeTest {

    @Test
    public void hashcodeTest() {
        String key = "name";
        System.out.println(key.hashCode()); //3373707
    }

    @Test
    public void hashMap_hashcode_Test() {
        String key = "name";
        int h;
        int i = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        System.out.println(i); //3373752
    }

    /**
     * 异或运算测试;
     */
    @Test
    public void yihuoTest() {
        int a = 15;
        int b = 2;
        System.out.println("a^b=" + (a ^ b));

        int f = 50;
        int g = 60;
        f = f ^ g;
        System.out.println("f: " + f); //14
        g = f ^ g;
        System.out.println("g: " + g); //50
        f = f ^ g;
        System.out.println(f + " " + g); //60 50
    }

    @Test
    public  void  nodeTest(){
//        Node
        int a = 15;
        int b = 2;
        System.out.println("a & b=" + (a & b));

    }

    @Test
    public  void tt(){
        Pattern pattern = Pattern.compile("^[0-9]*$");
        boolean matches = pattern.matcher("123#421").matches();
        System.out.println(matches);
    }
}
