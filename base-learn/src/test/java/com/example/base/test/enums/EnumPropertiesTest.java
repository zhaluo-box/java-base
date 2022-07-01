package com.example.base.test.enums;

import com.example.base.learn.enums.EnumProperties;
import org.junit.Test;

/**
 * Created  on 2022/7/1 15:15:19
 *
 * @author zl
 */
public class EnumPropertiesTest {

    @Test
    public void propertiesGetTest() {
        System.out.println(EnumProperties.MAN.getDesc());
    }
}
