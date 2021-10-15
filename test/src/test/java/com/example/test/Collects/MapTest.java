package com.example.test.Collects;

import org.junit.Test;

import java.util.HashMap;

public class MapTest {

    @Test
    public void putAllTest() {
        var map = new HashMap<String, String>();
        map.put("aaa",null);
        System.out.println(map);
        var map2 = new HashMap<String, String>();
        map2.put("aaa","123");
        map2.put("bbb","123");
        System.out.println(map2);
        map.putAll(map2);
        System.out.println(map);
    }
}
