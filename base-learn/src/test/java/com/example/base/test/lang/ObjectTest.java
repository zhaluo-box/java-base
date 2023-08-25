package com.example.base.test.lang;

import cn.hutool.json.JSONUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created  on 2023/3/17 09:9:20
 *
 * @author zl
 */
public class ObjectTest {

    @Test
    @DisplayName(("测试两个不同的对象是否相等"))
    public void testDiffObjectEqu() {
        Long longNumber = 12011L;
        Integer integerNumber = Integer.valueOf("12011");
        System.out.println(Objects.equals(longNumber, integerNumber));
    }

    /**
     * 结论： json 序列化， 反序列化之后对象类型会丢失
     */
    @Test
    @DisplayName("json 序列化之后，对象是否相等测试")
    public void jsonSerializeAfterEqualsTest() {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "张三");
        map.put("age", Long.valueOf("12"));
        map.put("age1", Integer.valueOf("12"));
        map.put("money", new BigDecimal("9019231.22"));

        var jsonStr = JSONUtil.toJsonStr(map);

        var map1 = JSONUtil.toBean(jsonStr, Map.class);
        System.out.println(map1);

        System.out.println(Objects.equals(map1.get("age1"), map.get("age")));

        map1.forEach((k, v) -> System.out.println(v.getClass()));
    }

}
