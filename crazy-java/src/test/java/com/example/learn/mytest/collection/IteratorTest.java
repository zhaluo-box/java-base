package com.example.learn.mytest.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 容器迭代器测试
 * Created  on 2022/5/19 16:16:58
 *
 * @author zl
 */
public class IteratorTest {

    private List<String> initList() {
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        return list;
    }

    private List<Node> initNodes() {
        List<Node> list = new ArrayList<>();
        list.add(new Node("张三", ""));
        list.add(new Node("李四", ""));
        list.add(new Node("王五", ""));
        list.add(new Node("赵六", ""));
        return list;
    }

    @Test
    public void test2() {
        List<Node> nodes = initNodes();
        for (Node node : nodes) {
            Node exampleNode = new Node("张三", "");
            if (exampleNode.equals(node)) {
                nodes.remove(node);
            }
        }
        System.out.println(nodes);
    }

    @Test
    public void test3() {
        List<String> list = new ArrayList<>();
        list.add("001");
        list.add("002");
        list.add("003");

        list.removeIf("002"::equals);
    }

    /**
     * 并发修改异常测试：
     * 移除 当前元素
     * 结果，
     * --张三
     * --李四
     * --王五
     * --[张三, 李四, 赵六]
     * =====》没有发生预期的并发修改异常
     * 纯属巧合导致， 导致下次迭代器遍历的时候 hasNext 游标==容器的大小，没有调用 next 的检查，直接就结束的遍历
     * 因为 if (王五） 刚好是倒数第二个元素，迭代器的游标 下次调用hasNext的时候刚刚好3 而list的size 也刚好是3
     * cursor != size 刚好返回false. 所以next（） 获取元素中的检查modCount != expectedModCount 没有触发，导致没有抛出预期的异常
     * public boolean hasNext() {
     * return cursor != size;
     * }
     */
    @Test
    public void test4() {
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        for (String str : list) {
            System.out.println(str);
            if ("王五".equals(str)) {
                list.remove("王五");
            }
        }
        System.out.println(list);
    }

    /**
     * 并发修改异常测试：
     * 移除 当前元素
     * 结果，
     * --张三
     * --李四
     * --王五
     * --[张三, 李四, 赵六]
     * =====》没有发生预期的并发修改异常
     */
    @Test
    public void test4_1() {
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        for (String str : list) {
            System.out.println(str);
            if ("李四".equals(str)) {
                list.remove("王五");
            }
        }
        System.out.println(list);
    }

    /**
     * 并发修改异常测试：
     * 移除 后面的元素
     * --张三
     * --李四
     * --王五
     * --[张三, 李四, 王五]
     * =====》 也没有发生预期的并发修改异常
     */
    @Test
    public void test5() {
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        for (String str : list) {
            System.out.println(str);
            if ("王五".equals(str)) {
                list.remove("赵六");
            }
        }
        System.out.println(list);
    }

    /**
     * 并发修改异常测试：
     * 移除 前面的元素
     * --张三
     * --李四
     * --java.util.ConcurrentModificationException
     * ===》 发生了预期的并发修改异常
     */
    @Test
    public void test6() {
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        for (String str : list) {
            System.out.println(str);
            if ("李四".equals(str)) {
                list.remove("王五");
            }
        }
        System.out.println(list);
    }

    @Data
    @EqualsAndHashCode
    @AllArgsConstructor
    public static class Node {
        private String name;

        private String desc;
    }
}
