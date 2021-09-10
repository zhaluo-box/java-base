package com.zhaluobox.crazyjava.chapter08.chapter08_05_Queue集合;


import java.util.*;

/**
 * 双端队列. 支持头尾操作.
 *
 * Description:后进先出
 * 1.Deque接口是Queue接口的子接口，它是一个双端队列
 * 2.ArrayDeque实现类，创建Deque同样可以指定一个numElements参数，用于指定Object[]数组长度，默认16
 * 3.下面演示将ArrayDeque当成栈来使用。
 */
public class ArrayDequeStack {

    public static ArrayDeque stack = new ArrayDeque();

    public static void main(String[] args) {

		// 初始化
		init();

        // 访问第一个元素，但并不将其pop出"栈"，输出：疯狂Android讲义
        System.out.println( stack.peek() );

        // 依然输出：[疯狂Android讲义, 疯狂Java讲义, 轻量级Java EE企业应用实战]
        System.out.println( stack );

        // pop出第一个元素，输出：疯狂Android讲义
        System.out.println( "演示队列出队的顺序===>>>" );
        System.out.println( stack.pop() );
        System.out.println( stack.pop() );
        System.out.println( stack.pop() );

        // 初始化
		init();

		System.out.println( stack.isEmpty() );
		stack.spliterator().forEachRemaining( System.out::println );


		// 输出：[轻量级Java EE企业应用实战, 疯狂Java讲义]
        System.out.println( stack );

    }


    /**
     * 初始化双端队列.
     */
    public static void init() {

        // 依次将三个元素push入"栈"
        stack.push( "疯狂Java讲义" );
        stack.push( "轻量级Java EE企业应用实战" );
        stack.push( "疯狂Android讲义" );

        // 输出：[疯狂Android讲义, 轻量级Java EE企业应用实战, 疯狂Java讲义]
        System.out.println( stack );
    }
}
