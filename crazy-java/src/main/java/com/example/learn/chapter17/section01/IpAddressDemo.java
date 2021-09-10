package com.zhaluobox.crazyjava.chapter17.section01;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        final InetAddress address = InetAddress.getByName("172.24.107.220");
        System.out.println(address.getAddress().toString());
        System.out.println(address.getHostName());
        System.out.println(address.getCanonicalHostName());
        System.out.println(address.getHostAddress());
    }

}
