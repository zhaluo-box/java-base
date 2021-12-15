package com.example.pattern.creational.single;

import com.example.learn.pattern.creational.single.impl.EnumStarvingSingleton;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * 单例模式测试
 */
public class SingletonTest {

    /**
     * 通过反射创建实例, 单例依旧没有办法避免反射创建生成不同的对象!
     */
    @Test
    public void enumSingletonTest() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        System.out.println(EnumStarvingSingleton.getInstance());
        var clazz = EnumStarvingSingleton.class;
        var declaredConstructor = clazz.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        System.out.println(declaredConstructor.newInstance());

    }
}
