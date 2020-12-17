package com.zc.base.nios;

import org.springframework.core.io.ClassPathResource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo {

    public static void main(String[] args) throws IOException {

        RandomAccessFile inputStream = new RandomAccessFile("C:\\java\\workplace\\idea\\my-pro\\base\\src\\main\\resources\\app.properties","rw");
        FileChannel fileChannel = inputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(5);
        int len = fileChannel.read(buffer);
        StringBuilder sbd = new StringBuilder();
        while(len != -1){
            System.out.println("打印读取的内容,len = " + len);
            buffer.flip();
            while(buffer.hasRemaining()){
                sbd.append((char)buffer.get()); //每次获取1字节，如使用sbd.append(buffer),不能放在while循环里
            }
            buffer.clear();
            len = fileChannel.read(buffer);
        }
        System.out.println(sbd.toString());
    }

}
