package com.zhaluobox.crazyjava.chapter18.section03;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class RefectDemo {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException {

        refect1();
        // refect2();

    }

    private static void refect1() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        // 下面代码可以获取ClassTest对应的Class
        final Class<ClassTest> testClass = ClassTest.class;
        // 获取该Class对象所对应类的全部构造器
        final Constructor<?>[] declaredConstructors = testClass.getDeclaredConstructors();
        System.out.println("ClassTest的全部构造器如下：");
        Arrays.stream(declaredConstructors).forEach( t ->System.out.println(t));

        // 获取该Class对象所对应类的全部public构造器
        final Constructor<?>[] constructors = testClass.getConstructors();
        System.out.println("ClassTest的全部public构造器如下：");
        Arrays.stream(constructors).forEach(t -> System.out.println(t));

        // 获取该Class对象所对应类的全部public方法
        final Method[] methods = testClass.getMethods();
        System.out.println("ClassTest的全部public方法如下：");
        Arrays.stream(methods).forEach(System.out::println);

        // 获取该Class对象所对应类的指定方法
        final Method info = testClass.getMethod("info", String.class);

        // 获取该Class对象所对应类的上的全部注解
        final Annotation[] annotations = testClass.getAnnotations();
        Arrays.stream(annotations).forEach(System.out::println);
        System.out.println("-----------------------------");
        System.out.println("该Class元素上的@SuppressWarnings注解为："
                + Arrays.toString(testClass.getAnnotationsByType(SuppressWarnings.class)));
        System.out.println("该Class元素上的@Anno注解为："
                + Arrays.toString(testClass.getAnnotationsByType(Anno.class)));
        System.out.println("-----------------------------");

        // 获取该Class对象所对应类的全部内部类
        final Class<?>[] declaredClasses = testClass.getDeclaredClasses();
        System.out.println("ClassTest的全部内部类如下：");
        Arrays.stream(declaredClasses).forEach(System.out::println);

        // 使用Class.forName方法加载ClassTest的Inner内部类
        //        Class inclazz1 = Class.forName("ClassTest$Inner");
        // 通过getDeclaringClass()访问该类所在的外部类

    }

    private static void refect2() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        final Class<?> clazz = Class.forName( "com.zhaluobox.crazyjava.chapter18.section03.Emp" );
        final Class<Emp> empClass = Emp.class;
        final Emp e = (Emp) clazz.newInstance();
        final Class<? extends Emp> aClass = e.getClass();

        //获取构造
        // 获取所有public构造
        final Constructor<?>[] constructors = clazz.getConstructors();
        Arrays.stream(constructors).forEach(t ->
        {
            System.out.println(t);
            System.out.println("参数个数" + t.getParameterCount());
        });

        // 获取所有构造.不分权限
        final Constructor<?>[] constructors2 = clazz.getDeclaredConstructors();
        //        final Constructor<?> constructor = clazz.getDeclaredConstructor(int.class, String.class, String.class);

        //  获取注解
        final Annotation[] annotations = clazz.getAnnotations();
        Arrays.stream(annotations).forEach(t -> {
            System.out.println(t.annotationType());
        });

        //获取字段
        final Field[] declaredFields = clazz.getDeclaredFields();
        Arrays.stream(declaredFields).forEach(
                t -> System.out.println(t.getName())
        );
    }
}
