package com.zc.base.concurrent.futures;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompleteFutureTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompleteFutureTest.class);

    public static void main(String[] args) {
        testAsync();
        System.out.println("主线程执行完了");
    }

    public static void testAsync(){

        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("中断错误");
            }
            System.out.println("洗菜");
            doOther();
            return "猪肉";
        }).exceptionally(throwable -> {
            System.err.println(throwable);
            System.err.println(throwable.toString());
            System.err.println(throwable.getCause().getStackTrace()[0]);
            LOGGER.error("错误", throwable);
            return "没洗好";
        });

        f1.thenAccept( s -> {
//            if(true){
//                throw new RuntimeException("停电了");
//            }
            System.out.println("做饭：" + s);
        }).exceptionally(throwable -> {
           throwable.printStackTrace();
           return null;
        });

    }

    private static void doOther() {

        System.out.println("之前");

        int[] a = new int[1];
        a[2] = 2;

        System.out.println(a);

    }

}
