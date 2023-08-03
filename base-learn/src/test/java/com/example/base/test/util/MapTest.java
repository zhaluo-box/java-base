package com.example.base.test.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Created  on 2023/8/2 14:14:48
 *
 * @author zl
 */
public class MapTest {

    @Test
    @DisplayName("Map 循环删除测试")
    public void loopRemoveTest() {

        Set<String> masterDataScopes = Set.of("1", "4");

        Map<String, String> dataSegregationFields = new HashMap<>();

        dataSegregationFields.put("1", "1");
        dataSegregationFields.put("2", "2");
        dataSegregationFields.put("3", "3");
        dataSegregationFields.put("4", "4");

        try {
            dataSegregationFields.forEach((k, v) -> {
                if (masterDataScopes.contains(k)) {
                    dataSegregationFields.remove(k);
                }
            });
        } catch (ConcurrentModificationException e) {
            System.out.println("并发修改异常" + e.getMessage());
        }

        System.out.println("dataSegregationFields = " + dataSegregationFields);

    }

    @Test
    @DisplayName("迭代器删除测试")
    public void iteratorRemoveTest() {
        Set<String> masterDataScopes = Set.of("1", "4");

        Map<String, String> dataSegregationFields = new HashMap<>();

        dataSegregationFields.put("1", "1");
        dataSegregationFields.put("2", "2");
        dataSegregationFields.put("3", "3");
        dataSegregationFields.put("4", "4");

        Iterator<Map.Entry<String, String>> iterator = dataSegregationFields.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            String dataType = next.getKey();
            if (masterDataScopes.contains(dataType)) {
                iterator.remove();
            }
        }

        System.out.println("dataSegregationFields = " + dataSegregationFields);
    }
}
