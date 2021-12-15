package com.example.pattern.creational.single;

import com.example.learn.pattern.creational.single.impl.StaticInnerClass;
import org.junit.Test;

/**
 *
 */
public class InnerClassTest {

    @Test
    public void test(){
        System.out.println(StaticInnerClass.getInstance());
        System.out.println(StaticInnerClass.getInstance());
    }
}
