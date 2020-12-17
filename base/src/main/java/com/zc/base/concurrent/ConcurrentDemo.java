package com.zc.base.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentDemo {

    public static void main(String[] args){

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CountDownLatch countDownLatch = new CountDownLatch(1);

        // 公平锁
        ReentrantLock lock = new ReentrantLock(true);
        AtomicInteger addLockCount = new AtomicInteger(0);
        AtomicInteger cancelLockCount = new AtomicInteger(0);

        for(int i = 1; i <= 10; i ++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        countDownLatch.await();
                        lock.lock();
                        Thread.sleep(1000);
                        System.out.println("===========================  加一次锁：" + addLockCount.incrementAndGet());
                        lock.lock();
                        System.out.println("===========================  加二次锁：" + addLockCount.incrementAndGet());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                        System.out.println("===========================  解一次锁：" + cancelLockCount.incrementAndGet());
                        lock.unlock();
                        System.out.println("===========================  解二次锁：" + cancelLockCount.incrementAndGet());
                    }

                }
            });
        }

        countDownLatch.countDown();
    }

}
