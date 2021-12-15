package com.example.test.reflect;

import com.example.entity.Person;
import com.example.entity.Reflect.ReflectTarget;
import lombok.SneakyThrows;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLStreamHandlerFactory;

/**
 * 发射测试
 */
public class ReflectTest {

    /**
     * 测试构造
     */
    @Test
    @SneakyThrows
    public void testReflectConstructor() {
        Class<?> reflectTarget = Class.forName("com.example.entity.Reflect.ReflectTarget");

        testErrorCase(reflectTarget);
        testPackageNoArgConstructor(reflectTarget);
        testPublicConstructor(reflectTarget);
        testPrivateContructor(reflectTarget);
        testProtectedConstructor(reflectTarget);

    }

    /**
     * 测试成员变量
     */
    @Test
    @SneakyThrows
    public void testReflectField() {
        Class<?> reflectTarget = Class.forName("com.example.entity.Reflect.ReflectTarget");

        var instance = getReflectTarget(reflectTarget);
        System.out.println("=======================测试获取变量=================================");
        testGetField(reflectTarget, instance);
        System.out.println("===========================测试设置变量值 ==========================");
        testSetField(reflectTarget, instance);

    }

    /**
     * 测试成员方法
     */
    @Test
    @SneakyThrows
    public void testReflectMethod() {
        Class<?> reflectTarget = Class.forName("com.example.entity.Reflect.ReflectTarget");

        var instance = getReflectTarget(reflectTarget);

        // 获取所有公有方法
        var methods = reflectTarget.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
        // 获取所有声明的方法
        var declaredMethods = reflectTarget.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
        // 获取指定的方法
        var method = reflectTarget.getMethod("getName");
        System.out.println(method);
        method.invoke(instance);

        // 执行方法
        var declaredMethod = reflectTarget.getDeclaredMethod("getAge", int.class);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(instance, 20);
    }

    @SneakyThrows
    @Test
    public void main() {
        Person person = new Person();
        person.setName("VipMao");
        person.setAge(24);
        person.setSex("男");
        //通过Class.getDeclaredField(String name)获取类或接口的指定属性值。
        Field f1 = person.getClass().getDeclaredField("name");
        System.out.println("-----Class.getDeclaredField(String name)用法-------");
        System.out.println(f1.get(person));
        System.out.println("-----Class.getDeclaredFields()用法-------");
        //通过Class.getDeclaredFields()获取类或接口的指定属性值。
        Field[] f2 = person.getClass().getDeclaredFields();
        for (Field field : f2) {
            field.setAccessible(true);
            System.out.println(field.get(person));
        }
        //修改属性值
        System.out.println("----修改name属性------");
        f1.set(person, "Maoge");
        //修改后再遍历各属性的值
        Field[] f3 = person.getClass().getDeclaredFields();
        for (Field fields : f3) {
            fields.setAccessible(true);
            System.out.println(fields.get(person));
        }
    }

    @SneakyThrows
    @Test
    public void test() {
        final Field factoryField = URL.class.getDeclaredField("factory");
        //JAVA16以上版本，启动时，请携带：--add-opens java.base/java.net=ALL-UNNAMED参数
        //否则可能出现：module java.base does not "opens java.net"错误
        factoryField.setAccessible(true);
        final Field lockField = URL.class.getDeclaredField("streamHandlerLock");
        lockField.setAccessible(true);
        System.out.println(lockField.get(null));
        URLStreamHandlerFactory originalUrlStreamHandlerFactory = (URLStreamHandlerFactory) factoryField.get(null);
        System.out.println(originalUrlStreamHandlerFactory);
    }

    private void testSetField(Class<?> reflectTarget, ReflectTarget instance) throws NoSuchFieldException, IllegalAccessException {
        var addressField = reflectTarget.getField("address");
        addressField.set(instance, "上海");
        System.out.println(instance);
    }

    private void testGetField(Class<?> reflectTarget, ReflectTarget instance) throws IllegalAccessException, NoSuchFieldException {
        // 获取所有公有成员 allPublicField
        testGetField(reflectTarget);

        testGetDeclaredField(reflectTarget, instance);

        // 获取指定公有变量
        var addressField = reflectTarget.getField("address");
        System.out.println(addressField.get(instance));

        // 获取声明的变量
        var nameField = reflectTarget.getDeclaredField("name");
        nameField.setAccessible(true);
        System.out.println(nameField.get(instance));
    }

    private void testGetField(Class<?> reflectTarget) {
        var fields = reflectTarget.getFields();
        for (Field f : fields) {
            System.out.println(f);
        }
    }

    private void testGetDeclaredField(Class<?> reflectTarget, ReflectTarget instance) throws IllegalAccessException {
        // 获取所有声明的成员变量
        var declaredFields = reflectTarget.getDeclaredFields();
        for (Field f : declaredFields) {
            System.out.println("变量 :　" + f);
            f.setAccessible(true);
            System.out.println("变量的值 : " + f.get(instance));
        }
    }

    private ReflectTarget getReflectTarget(Class<?> clazz) throws
                    NoSuchMethodException,
                    InvocationTargetException,
                    InstantiationException,
                    IllegalAccessException {
        Constructor<?> allArgConstructor = clazz.getConstructor(String.class, int.class, String.class, String.class);
        return (ReflectTarget) allArgConstructor.newInstance("贝贝", 12, "北京", "99881133");

    }

    /**
     * no Access Permission
     */
    private void testErrorCase(Class<?> reflectTarget) {
        try {
            // reflectTarget　无参构造是包下访问的,通过getConstructor 是无法构造的,
            Constructor<?> constructor = reflectTarget.getConstructor();
            var errObj = (ReflectTarget) constructor.newInstance();
            System.out.println(errObj);
        } catch (Exception e) {
            //            System.out.println(e.getMessage());
            System.out.println(ExceptionUtils.getStackTrace(e));
        }
    }

    private void testPackageNoArgConstructor(Class<?> reflectTarget) throws
                    NoSuchMethodException,
                    InstantiationException,
                    IllegalAccessException,
                    InvocationTargetException {
        // package 构造
        Constructor<?> noArgConstructor = reflectTarget.getDeclaredConstructor();

        // 包级别访问权限,需要设定访问权限,
        noArgConstructor.setAccessible(true);
        Object noArg = noArgConstructor.newInstance();
        System.out.println(noArg);
    }

    private void testPublicConstructor(Class<?> reflectTarget) throws
                    NoSuchMethodException,
                    InstantiationException,
                    IllegalAccessException,
                    InvocationTargetException {
        // public 构造
        Constructor<?> publicConstructor = reflectTarget.getDeclaredConstructor(String.class, int.class);
        // 公有的无需设置访问权限
        var obj = (ReflectTarget) publicConstructor.newInstance("zhang san", 12);
        System.out.println(obj);
    }

    private void testPrivateContructor(Class<?> reflectTarget) throws
                    NoSuchMethodException,
                    InstantiationException,
                    IllegalAccessException,
                    InvocationTargetException {
        // private构造
        Constructor<?> privateConstructor = reflectTarget.getDeclaredConstructor(String.class);
        privateConstructor.setAccessible(true);
        var privateArg = (ReflectTarget) privateConstructor.newInstance("name");
        System.out.println(privateArg);
    }

    private void testProtectedConstructor(Class<?> reflectTarget) throws
                    NoSuchMethodException,
                    InstantiationException,
                    IllegalAccessException,
                    InvocationTargetException {
        //protected 构造
        Constructor<?> protectedConstructor = reflectTarget.getDeclaredConstructor(String.class, int.class, String.class);
        protectedConstructor.setAccessible(true);
        var protectedArg = (ReflectTarget) protectedConstructor.newInstance("name", 12, "北京");
        System.out.println(protectedArg);
    }

}
