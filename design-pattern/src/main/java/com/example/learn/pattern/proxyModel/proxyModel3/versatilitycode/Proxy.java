package com.example.learn.pattern.proxyModel.proxyModel3.versatilitycode;


/**
 * 通用代理类
 *
 * @author 扎罗
 * @version 1.0.0
 * @Date 2020-9-25 14:28
 */
public class Proxy implements Subject {

    //  要代理哪个实现类
    private Subject subject = null;

    //  默认被代理者
    public Proxy() {
        // 实现类= new自己
        this.subject = new Proxy();
    }

    //     通过构造函数传递代理者
    public Proxy(Object... objects) {

    }

    /**
     * 在构造函数中传递'被代理者'
     * @param subject 被代理者
     */
    public Proxy(Subject subject) {
        this.subject = subject;
    }

    //实现接口中定义的方法
    public void request() {
        this.before();
        this.subject.request();
        this.after();
    }

    //     预处理
    private void before() {
        //do something
    }

    //善后处理
    private void after() {
        // do something
    }


}
