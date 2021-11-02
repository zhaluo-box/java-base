package com.example.test.Collects;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class MapTest {

    @Test
    public void putAllTest() {
        var map = new HashMap<String, String>();
        map.put("aaa", null);
        System.out.println(map);
        var map2 = new HashMap<String, String>();
        map2.put("aaa", "123");
        map2.put("bbb", "123");
        System.out.println(map2);
        map.putAll(map2);
        System.out.println(map);

    }

    @Test
    public void testRemove() {
        var map = new HashMap<String, String>();
        map.put("a", "aa");
        map.put("b", "bb");
        map.put("c", "cc");
        map.put("d", "dd");

        // 并发修改异常
        map.forEach((k, v) -> {
            if (k.equals("a")) {
                map.remove(k);
            }
        });

        var list = new ArrayList<Map<String, Object>>();

        System.out.println(map);
    }
}
