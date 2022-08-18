package com.example.base.test.collection;

import org.junit.Test;

import java.util.*;

/**
 * 测试forEach方法
 */
public class ForEachTest {

    @Test
    public void arrTest() {

        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(13);
        list.add(1312);
        list.add(1311);
        list.add(12);
        for (Integer ii : list) {
            System.out.println(ii + 3);
        }
        list.forEach((i) -> {
            System.out.println(i + 3);
        });

    }

    @Test
    public void mapTest() {

        HashMap<String, Object> map = new HashMap<>();
        map.put("西游记", 112);
        map.put("水浒传", 993);
        map.put("红楼梦", 322);
        map.put("三国演义", 998);
        System.out.println("--------------------map的原始遍历方式 1-----------------------");
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            if ("西游记".equals(key)) {
                map.put("西游记", "吴承恩");
            }
            System.out.println(key + " :  " + map.get(key));
        }
        System.out.println("--------------------map的原始遍历方式 2-----------------------");
        Set<Map.Entry<String, Object>> entries = map.entrySet();
        for (Map.Entry<String, Object> mp : entries) {
            String key = mp.getKey();
            Object value = mp.getValue();
            if ("西游记".equals(key)) {
                map.put("西游记", 998998989);
            }
            System.out.println(key + " :  " + value);
        }

        System.out.println("--------------------map的Lamdba遍历方式 3-----------------------");
        map.forEach((key, value) -> {
            if ("西游记".equals(key)) {
                map.put("西游记", "吴承恩");
            }
            System.out.println(key + " :  " + value);
        });

        /*
            值得一提的java8 提供的forEach方法 操作的map集合,其实是取出entry对象在操作...
            所以在修改过后再去遍历.还是原来的entry
         */
        System.out.println("--------------------------再遍历一次map--------------------------------");
        map.forEach((key, value) -> {
            System.out.println(key + " :  " + value);
        });
    }
}
