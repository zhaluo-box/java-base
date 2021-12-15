package com.example.test.network.url;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

/**
 *
 */
public class CustomURLStreamHandler extends URLStreamHandler {

    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        return new CustomUrlConnection(u);
    }

    static class CustomUrlConnection extends URLConnection {

        /**
         * Constructs a URL connection to the specified URL. A connection to
         * the object referenced by the URL is not created.
         *
         * @param url the specified URL.
         */
        protected CustomUrlConnection(URL url) {
            super(url);
        }

        @Override
        public void connect() throws IOException {
            throw new RuntimeException("自定义协议不支持连接!");
        }

        @Override
        public InputStream getInputStream() throws IOException {
            var content = new byte[] {};
            var byteArrayInputStream = new ByteArrayInputStream(content);
            return super.getInputStream();
        }
    }

}
