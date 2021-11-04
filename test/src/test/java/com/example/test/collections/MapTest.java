package com.example.test.collections;

import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    public void test() {
        System.out.println("log4");
    }

    private Map<String, Object> toLowerCaseKey(Map<String, Object> data) {

        if (CollectionUtils.isEmpty(data)) {
            return data;
        }

        var result = new HashMap<String, Object>(data.size());
        data.forEach((k, v) -> result.put(k.toLowerCase(), v));
        return result;
    }

    @Test
    public void testLowerCase() {
        var map = new HashMap<String, Object>();
        map.put("PATIENT_ID", "123");
        map.put("VISIT_ID", 1);

        System.out.println(map);

        System.out.println(toLowerCaseKey(map));

    }
}
