package com.zc.base.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReadWriteLockDemo {

    public static void main(String[] args) throws InterruptedException {

        int count = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(count);

        CyclicBarrier barrier = new CyclicBarrier(count);

        CachedData cachedData = new CachedData();

        for(int i = 0; i < 10; i ++){
            executorService.submit(() -> {
                try {
                    barrier.await();
                    cachedData.processCachedData();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

    }

}
