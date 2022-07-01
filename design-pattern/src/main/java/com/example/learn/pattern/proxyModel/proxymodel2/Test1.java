package com.example.learn.pattern.proxyModel.proxymodel2;

public class Test1 {
    public static void main(String[] args) throws Exception {
        final BeautifulGirl xmy = new Xmy();
        BeautifulGirl x = (BeautifulGirl) GirlFactoryProxy.getProxy(xmy);
        x.fish();
        x.legs();
    }
}
