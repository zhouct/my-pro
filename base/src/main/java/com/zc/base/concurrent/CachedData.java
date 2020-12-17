package com.zc.base.concurrent;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CachedData {

    Object data;
    volatile boolean cacheValid;

    final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    void processCachedData() throws InterruptedException {
        rwl.readLock().lock();
        System.out.println("获取读锁线程：" + Thread.currentThread().getName());
        if(!cacheValid){
            /**
             * 获取读锁后不能继续获取写锁，必须先释放
             */
            Thread.sleep(3000);
            rwl.readLock().unlock();
            System.out.println("释放读锁线程：" + Thread.currentThread().getName());
            rwl.writeLock().lock();
            System.out.println("获取写锁线程：" + Thread.currentThread().getName());

            try {
                if(!cacheValid){
                    data = new Object();
                    cacheValid = true;
                }
                /**
                 * 获取写锁后，可以继续获取读锁
                 */
                rwl.readLock().lock();
                System.out.println("降级获取读锁线程：" + Thread.currentThread().getName());
            }finally {
                rwl.writeLock().unlock();
                System.out.println("释放写锁线程：" + Thread.currentThread().getName());
            }
        }

        try {
            use(data);
        }finally {
            rwl.readLock().unlock();
            System.out.println("最后释放读锁线程：" + Thread.currentThread().getName());
        }
    }

    private void use(Object data) {
        System.out.println("CachedData.use");
    }

}
