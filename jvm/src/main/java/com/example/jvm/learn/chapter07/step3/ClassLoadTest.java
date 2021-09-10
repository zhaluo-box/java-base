package com.example.jvm.learn.chapter07.step3;


import java.io.IOException;
import java.io.InputStream;

/**
 * 演示不同类加载器对 instanceof 结果的影响
 */
public class ClassLoadTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    // 截取 "." 之前的部分
                    String filename = name.substring( name.lastIndexOf( "." ) + 1 ) + ".class";
                    InputStream is = getClass().getResourceAsStream( filename );
                    if (is == null) {
                        return super.loadClass( name );
                    }
                    byte[] b = new byte[is.available()];
                    is.read( b );
                    return defineClass( name, b, 0, b.length );
                } catch (IOException e) {
                    throw new ClassNotFoundException( name );
                }
            }
        };

        Object obj = myLoader.loadClass( "com.example.jvm.learn.chapter07.step3.ClassLoadTest" ).newInstance();
        System.out.println( obj.getClass() );
        System.out.println( obj instanceof com.example.jvm.learn.chapter07.step3.ClassLoadTest );
    }
}
