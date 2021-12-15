package com.example.entity.Reflect;

/**
 * 反射测试用实体类
 * 访问权限:  公有,私有,默认,受保护
 */
public class ReflectTarget {

    // 成员变量

    private String name;

    protected int age;

    public String address;

    String idCard;

    // 构造
    ReflectTarget() {
        System.out.println("默认构造");
    }

    private ReflectTarget(String name) {
        this.name = name;
        System.out.println("私有构造,名称 : " + name);
    }

    public ReflectTarget(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("公有构造");
    }

    protected ReflectTarget(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
        System.out.println("受保护的构造");
    }

    public ReflectTarget(String name, int age, String address, String idCard) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.idCard = idCard;
        System.out.println("all arg constructor !");
    }

    // 成员方法
    public String getName() {
        System.out.println("执行方法 : " + this.name);
        return this.name;
    }

    private int getAge(int age) {
        System.out.println(age);
        return age;
    }

    void sayHi() {
        System.out.println("Welcome Reflect!");
    }

    protected void getAddress() {
        System.out.println("地址: " + this.address);
    }

    @Override
    public String toString() {
        return "ReflectTarget{" + "name='" + name + '\'' + ", age=" + age + ", address='" + address + '\'' + ", idCard='" + idCard + '\'' + '}';
    }
}
