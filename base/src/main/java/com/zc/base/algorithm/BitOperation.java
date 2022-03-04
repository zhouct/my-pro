package com.zc.base.algorithm;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class BitOperation {

    public static void main(String[] args) throws UnknownHostException {

        int a = 0b00000100;
        int b = 0b00000101;

        System.out.println(a);

        String host = "www.baidu.com";
        InetAddress[] allNames = InetAddress.getAllByName(host);

        for (InetAddress ip : allNames) {
            System.out.println(ip.getHostAddress());
        }

    }

}
