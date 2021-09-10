package com.example.learn.niuke.demo2;


/**
 * 算术运算符 测试
 *
 * @author 扎罗
 * @Date 2020-12-2 11:21
 * @version 1.0.0
 */
public class OperationalDemo {

    public static void main(String[] args) {

        // 三目运算
        threeMonadicOperation();
    }

    /**
     * 三元操作符类型的转换规则：
     * 1.若两个操作数不可转换，则不做转换，返回值为Object类型
     * 2.若两个操作数是明确类型的表达式（比如变量），则按照正常的二进制数字来转换，int类型转换为long类型，long类型转换为float类型等。
     * 3.若两个操作数中有一个是数字S,另外一个是表达式，且其类型标示为T，那么，若数字S在T的范围内，则转换为T类型；若S超出了T类型的范围，则T转换为S类型。
     * 4.若两个操作数都是直接量数字，则返回值类型为范围较大者
     *
     *
     * 三元操作符如果遇到可以转换为数字的类型，会做自动类型提升
     */
    private static void threeMonadicOperation () {
        Object o1 = true ? new Integer(1) : new Double(2.0);
        Object o2;
        if (true) {
            o2 = new Integer(1);
        } else {
            o2 = new Double(2.0);
        }
        System.out.print(o1);
        System.out.print(" ");
        System.out.print(o2);
    }


}
