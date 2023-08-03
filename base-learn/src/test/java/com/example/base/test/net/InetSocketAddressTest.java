package com.example.base.test.net;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * Created  on 2023/8/3 09:9:36
 *
 * @author zl
 */
public class InetSocketAddressTest {

    @Test
    @DisplayName("java 自带 Inet address api 测试")
    public void test() throws UnknownHostException {
        //  获取本机
        var inetSocketAddress = new InetSocketAddress(9987);
        System.out.println("inetSocketAddress.getAddress() = " + inetSocketAddress.getAddress());
        System.out.println("inetSocketAddress.getHostName() = " + inetSocketAddress.getHostName());
        System.out.println("inetSocketAddress.getPort() = " + inetSocketAddress.getPort());
        System.out.println("inetSocketAddress.getHostString() = " + inetSocketAddress.getHostString());

        // 指定host
        var localhost = new InetSocketAddress("localhost", 8823);
        System.out.println("localhost.getAddress() = " + localhost.getAddress());
        System.out.println("localhost.getHostName() = " + localhost.getHostName());
        System.out.println("localhost.getPort() = " + localhost.getPort());
        System.out.println("localhost.getHostString() = " + localhost.getHostString());

        var ad = new InetSocketAddress(InetAddress.getByName("192.168.1.74"), 8732);
        System.out.println("ad.getAddress() = " + ad.getAddress());
        System.out.println("ad.getPort() = " + ad.getPort());
        System.out.println("ad.getHostName() = " + ad.getHostName());
        System.out.println("ad.getHostString() = " + ad.getHostString());

    }

    @Test
    @DisplayName("InetAddress 构造测试")
    public void inetAddressCusTest() throws UnknownHostException {
        var localHost = InetAddress.getLocalHost();
        System.out.println("localHost.getHostAddress() = " + localHost.getHostAddress());
        System.out.println("localHost.getHostName() = " + localHost.getHostName());
        System.out.println("localHost.getCanonicalHostName() = " + localHost.getCanonicalHostName());

        var ad = InetAddress.getByName("192.168.1.74");
        System.out.println("ad.getHostName() = " + ad.getHostName());
        System.out.println("ad.getHostAddress() = " + ad.getHostAddress());
        System.out.println("ad.getHostName() = " + ad.getHostName());
        System.out.println("ad.getCanonicalHostName() = " + ad.getCanonicalHostName());
    }

}
