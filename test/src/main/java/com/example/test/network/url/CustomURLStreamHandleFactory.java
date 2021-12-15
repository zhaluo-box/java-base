package com.example.test.network.url;

import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

/**
 *
 */
public class CustomURLStreamHandleFactory implements URLStreamHandlerFactory {

    @Override
    public URLStreamHandler createURLStreamHandler(String protocol) {
        if (protocol.equalsIgnoreCase("自定义协议")) {
            return new CustomURLStreamHandler();
        }
        return null;
    }
}
