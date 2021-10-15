package com.example.test.stream;

import org.junit.Test;

import java.util.ArrayList;

public class StreamTest {

    @Test
    public void testStreamEndOperation() {
        var list = new ArrayList<String>();

        for (int i = 0; i < 10; i++) {
            list.add(i + "");
        }
        var sorted = list.stream().mapToInt(Integer::valueOf).sorted();
        var reduce = sorted.filter(x -> x > 5).reduce(Integer::sum);

        if (reduce.isPresent()) {
            System.out.println(reduce.getAsInt());
        }

    }
}
