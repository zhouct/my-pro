package com.zc.base;

import com.zc.base.concurrent.BoundedBuffer;
import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class BoundedBufferTest {

    public static final int THREAD_COUNT = 2000;

    @Test
    public void testBoundedBuffer() throws InterruptedException {

        BoundedBuffer boundedBuffer = new BoundedBuffer();
        AtomicInteger count = new AtomicInteger(0);
        ForkJoinPool forkJoinPool = new ForkJoinPool(THREAD_COUNT);

        forkJoinPool.execute(() -> IntStream.rangeClosed(1, THREAD_COUNT).parallel().forEach(item -> {
            try {
                boundedBuffer.put(new Object());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));

        forkJoinPool.execute(() -> IntStream.rangeClosed(1, THREAD_COUNT).parallel().forEach(item -> {
            try {
                Thread.sleep(20);
                count.incrementAndGet();
                System.out.println(count.get() + "---------------------------------" + boundedBuffer.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));

        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
    }

}
