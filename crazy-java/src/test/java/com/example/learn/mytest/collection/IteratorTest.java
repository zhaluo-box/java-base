package com.example.learn.mytest.collection;

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

    @Test
    public void test() {
        List<String> list = initList();
        for (String str : list) {
            //            try {
            if (str.equals("王五")) {
                list.remove("赵六");
            }
            //            } catch (Exception e) {
            //                // 预期抛出并发修改异常
            //                e.printStackTrace();
            //            }
        }
        System.out.println(list);
    }
}
