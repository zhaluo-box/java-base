package com.example.base.test.collection;

import com.example.base.learn.enums.NoValueEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
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

        System.out.println("sites 1: " + sites);

        // 创建另一个动态数组
        ArrayList<String> sites2 = new ArrayList<>();

        // 往动态数组中添加元素
        sites2.add("Wiki");
        sites2.add("Runoob");
        sites2.add("Google");
        System.out.println("sites2 2: " + sites2);

        // 保留元素
        boolean b = sites.retainAll(sites2);
        System.out.println("是否存在交集： " + b);
        System.out.println("sites的元素: " + sites);
        System.out.println("sites2的元素: " + sites2);

        boolean b1 = sites.retainAll(sites2);
        System.out.println(b1);
        System.out.println("保留的元素2: " + sites);
    }

    @Test
    @DisplayName("retain all 验证2 ，集合2 完全包含集合1 会出现什么清空")
    public void retainAllTest2() {

        // 创建一个动态数组
        ArrayList<String> sites = new ArrayList<>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        System.out.println("sites 1: " + sites);

        // 创建另一个动态数组
        ArrayList<String> sites2 = new ArrayList<>();
        sites2.add("Wiki");
        sites2.add("Runoob");
        sites2.add("Google");
        sites2.add("Taobao");
        System.out.println("sites2 2: " + sites2);

        System.out.println(sites.removeAll(sites2));
        System.out.println("集合1" + sites);
        System.out.println("集合2" + sites2);
    }

    @Test
    @DisplayName("remove all test")
    public void removeAllTest() {
        List<Integer> data = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        var changed = data.removeAll(List.of(1, 23, 4));
        System.out.println(changed);
        System.out.println(data);
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

    @Test
    public void testXX() {

        String source = "CTDP,SKDP,SKDJ,CTDJ", target = "SKDJ,SKDP,CTDJ";
        List<String> collectObj;
        collectObj = new ArrayList<>(Arrays.asList(source.split(",")));
        List<String> targetCollectObj = Arrays.asList(target.split(","));
        collectObj.removeAll(targetCollectObj);
    }

    /**
     * addAll(null) 会抛出空指针异常
     */
    @Test
    @DisplayName("test null be allow addAll")
    public void addAllTest() {
        List<String> list = new ArrayList<>(List.of("111"));
        List<String> other = List.of("12", "1223");
        list.addAll(null);
        System.out.println("list = " + list);
    }
}
