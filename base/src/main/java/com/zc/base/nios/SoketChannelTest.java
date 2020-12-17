package com.zc.base.nios;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SoketChannelTest {

    public static void main(String[] args) throws IOException {

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("http://127.0.0.1", 8080));

//        ByteBuffer bf = ByteBuffer.allocate(1024);
//        int read = socketChannel.read(bf);
//        while(read != -1){
//            bf.flip();
//            while (bf.hasRemaining()){
//                System.out.print((char)bf.get());
//            }
//            bf.clear();
//            read = socketChannel.read(bf);
//        }
//
//        socketChannel.close();

    }

}
