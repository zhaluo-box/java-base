package com.example.learn.pattern.proxyModel.proxymodel2;

public class Test1 {
    public static void main(String[] args) throws Exception{
        final BeautifulGril xmy = new Xmy();
        BeautifulGril x = (BeautifulGril)GrilFactoryProxy.getProxy(xmy);
        x.fish();
        x.legs();
    }
}
