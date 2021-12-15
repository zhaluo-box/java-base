package com.example.learn.pattern.creational.single.impl;

/**
 * 与静态内部类有异曲同工之妙, 都是依据JVM本身的创建唯一性来保证单例!
 */
public class EnumStarvingSingleton {

    private EnumStarvingSingleton() {
        System.out.println("构造私有");
    }

    public static final EnumStarvingSingleton getInstance() {
        return ContainerHolder.HOLDER.instance;
    }

    /**
     * 枚举在JVM本身就是单例
     */
    enum ContainerHolder {
        HOLDER;

        private EnumStarvingSingleton instance;

        ContainerHolder() {
            instance = new EnumStarvingSingleton();
        }

    }

}
