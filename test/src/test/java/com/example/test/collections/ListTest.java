package com.example.test.collections;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * list 测试
 * <p>
 * list 交集并集差集的一个测试
 * <p>
 * list1 = 1,2,3,4,5,6
 * list2 = 4,5,6,7,8,9
 * <p>
 * (1,2,3, (4,5,6,) 7,8,9)
 **/
public class ListTest {

    private static List<Integer> list1 = new ArrayList<>();
    private static List<Integer> list2 = new ArrayList<>();

    @Before
    public void initList() {
        Integer[] arr1 = {1, 2, 3, 4, 5, 6};
        Integer[] arr2 = {4, 5, 6, 7, 8, 9};

        list1.addAll(Arrays.asList(arr1));
        list2.addAll(Arrays.asList(arr2));

        System.out.println(list1);
        System.out.println(list2);
    }

    /**
     * 交集
     */
    @Test
    public void intersection() {
        list1.retainAll(list2);
        System.out.println("====================求交集 start=========================");
        System.out.println(list1);
        System.out.println(list2);
        System.out.println("====================求交集 end=========================");
    }

    /**
     * 并集
     */
    @Test
    public void union() {
        list1.removeAll(list2);
        list1.addAll(list2);
        System.out.println("=====================求并集 start=======================");
        System.out.println(list1);
        System.out.println(list2);
        System.out.println("=====================求并集 end=======================");
    }


    /**
     * 差集
     */
    @Test
    public void diffSet() {

        list1.removeAll(list2);
        System.out.println("=====================求并集 start=======================");
        System.out.println(list1);
        System.out.println(list2);
        System.out.println("=====================求并集 end=======================");

    }

    /**
     *
     */
    @After
    public void destroy() {
        list1.clear();
        list2.clear();

        System.out.println(list1);
        System.out.println(list2);
    }

    public void test() {
        System.out.println("测试git");
    }

    public void test2(){
        System.out.println("测试回退!");
    }
}
