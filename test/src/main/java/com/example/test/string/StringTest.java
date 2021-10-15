package com.example.test.string;

/**
 * Created by MingZhe on 2021/10/9 10:10:19
 *
 * @author wmz
 */
public class StringTest {

    public static void main(String[] args) {

        var str = "123汉字";
        var en = "AsszABB123";
        var other = "AsszABB123_";
        var par = "^[a-zA-z0-9_]+$";
        System.out.println(str.matches(par));
        System.out.println(en.matches(par));
        System.out.println(other.matches(par));

    }

}
