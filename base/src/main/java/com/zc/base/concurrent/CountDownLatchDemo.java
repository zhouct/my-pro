package com.zc.base.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        int count = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(count);
        CountDownLatch countDownLatch = new CountDownLatch(count);

        for(int i = 1; i <= count; i ++){
            executorService.execute(new WorkRunnable(countDownLatch, i));
        }

        for(int j = 1; j <= 10; j ++){
            new Thread(() -> {
                try {
                    countDownLatch.await();
                    System.out.println("线程j" + Thread.currentThread().getName() + "开始执行");
                    Thread.sleep(1000);
                    System.out.println("线程j" + Thread.currentThread().getName() + "执行完成");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        System.out.println("第二批线程唤醒");
        countDownLatch.await();

    }

}
