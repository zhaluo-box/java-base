package com.example.base.test.collection;

import com.example.base.learn.enums.NoValueEnum;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created  on 2022/5/25 10:10:35
 *
 * @author zl
 */
public class ListApiTest {

    @Test
    @DisplayName("集合包含方法测试")
    public void collectionContainTest() {
        var noValueEnums = new HashSet<NoValueEnum>(2);
        noValueEnums.add(NoValueEnum.OTHER);
        noValueEnums.add(NoValueEnum.DEFAULT);

        System.out.println(noValueEnums.contains(NoValueEnum.COMMON));
        System.out.println(noValueEnums.contains(NoValueEnum.OTHER));
    }

    /**
     * list 交集测试
     */
    @Test
    public void retainAllTest() {
        // 创建一个动态数组
        ArrayList<String> sites = new ArrayList<>();

        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");

        System.out.println("ArrayList 1: " + sites);

        // 创建另一个动态数组
        ArrayList<String> sites2 = new ArrayList<>();

        // 往动态数组中添加元素
        sites2.add("Wiki");
        sites2.add("Runoob");
        sites2.add("Google");
        System.out.println("ArrayList 2: " + sites2);

        // 保留元素
        boolean b = sites.retainAll(sites2);
        System.out.println(b);
        System.out.println("保留的元素: " + sites);
        boolean b1 = sites.retainAll(sites2);

        System.out.println(b1);
        System.out.println("保留的元素2: " + sites);
    }

    /**
     * 空list foreach
     */
    @Test
    @SuppressWarnings("all")
    public void emptyListForeachTest() {
        List<String> list = new ArrayList<>();
        System.out.println(list.isEmpty());
        list.forEach(System.out::println);
    }

    /**
     * 空list foreach
     * throw java.lang.NullPointerException: Cannot invoke "java.util.List.forEach(java.util.function.Consumer)" because "list" is null
     */
    @Test
    @SuppressWarnings("all")
    public void nullListForeachTest() {
        List<String> list = null;
        list.forEach(System.out::println);
    }
}
