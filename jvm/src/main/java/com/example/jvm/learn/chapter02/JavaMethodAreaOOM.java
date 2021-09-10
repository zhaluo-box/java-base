package com.example.jvm.learn.chapter02;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 *
 * 借助 CGlib 使方法区出现内存溢出异常
 *
 * -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 */
public class JavaMethodAreaOOM {

    static class OOMObject{

    }

    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            //        enhancer.setCallback(new MethodInterceptor() {
            //            @Override
            //            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            //                return methodProxy.invokeSuper(o,objects);
            //            }
            //        });

            //lamdba 表达式替代
            enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> methodProxy.invokeSuper(o,objects));
            enhancer.create();
        }
    }
}
