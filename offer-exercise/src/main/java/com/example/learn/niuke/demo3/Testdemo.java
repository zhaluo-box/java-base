package com.example.learn.niuke.demo3;

public class Testdemo {
    public static String output = "";

    public static void foo(int i) {
        try {
            if (i == 1) {
                throw new Exception();
            }
        } catch (Exception e) {
            output += "2";
            return;
        } finally {
            output += "3";
        }
        output += "4";
    }

    public static void main(String[] args) {
        foo(0);
        foo(1);
        System.out.println(output);
    }
}

class C {
    C() {
        System.out.print("C");
    }
}

class A {
    C c = new C();

    A() {
        this("A");
        System.out.print("A");
    }

    A(String s) {
        System.out.print(s);
    }
}

/**
 * 初始化过程是这样的：
 * 1.首先，初始化父类中的静态成员变量和静态代码块，按照在程序中出现的顺序初始化；
 * 2.然后，初始化子类中的静态成员变量和静态代码块，按照在程序中出现的顺序初始化；
 * 3.其次，初始化父类的普通成员变量和代码块，在执行父类的构造方法；
 * 4.最后，初始化子类的普通成员变量和代码块，在执行子类的构造方法；
 *
 * （1）初始化父类的普通成员变量和代码块，执行 C c = new C(); 输出C
 * （2）super("B"); 表示调用父类的构造方法，不调用父类的无参构造函数，输出B
 * （3） System.out.print("B");
 *  所以输出CBB
 */
class Test extends A {
    Test() {
        super("B");
        System.out.print("B");
    }

    public static void main(String[] args) {
        new Test();
    }
}
