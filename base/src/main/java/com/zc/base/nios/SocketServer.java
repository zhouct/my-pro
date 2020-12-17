package com.zc.base.nios;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class SocketServer {

    public static void main(String[] args) throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));
        while (true){
            SocketChannel accept = serverSocketChannel.accept();
            if(accept.isConnected()){
                System.out.println("-----------");
            }
        }

    }

}
