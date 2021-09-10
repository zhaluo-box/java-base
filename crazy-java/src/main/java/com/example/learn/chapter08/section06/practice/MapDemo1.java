package com.example.learn.chapter08.section06.practice;

import java.util.HashMap;


/**
 * map的深拷贝与浅拷贝的一些认知;
 *  map 利用putAll  可以从某种意义上实现深拷贝;
 *  因为map的value 可以传递引用类型 对于value的拷贝 依旧是引用拷贝
 */
public class MapDemo1 {

    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();
        map.put( "name", "刘德华" );
        map.put( "address", "香港" );
        map.put( "age", "20" );
        map.put( "sex", "男" );
        String numStr = new String( "123" );
        final Student student = new Student();
        student.setAge( 12 );
        student.setName( "哈哈怪" );
        map.put( numStr, student );

        HashMap<String, Object> copyMap = new HashMap<>( 4 );
        copyMap.putAll( map );

        System.out.println( map );
        System.out.println( copyMap );

        student.setName( "不是哈哈怪" );
        map.remove( "age" );

        System.out.println( map );
        System.out.println( copyMap );


    }
}

