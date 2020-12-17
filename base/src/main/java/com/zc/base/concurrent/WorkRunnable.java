package com.zc.base.concurrent;

import java.util.concurrent.CountDownLatch;

public class WorkRunnable implements Runnable{

    private CountDownLatch signLatch;
    private int i;

    WorkRunnable(CountDownLatch signLatch, int i){
        this.signLatch = signLatch;
        this.i = i;
    }

    @Override
    public void run() {
        doWork(i);
        signLatch.countDown();
    }

    private void doWork(int i) {
        try{
            if(i == 1){
                Thread.sleep(5000);
                System.out.println("线程：" + i + Thread.currentThread().getName() + "执行完成");
            }else if(i == 2){
                Thread.sleep(3000);
                System.out.println("线程：" + i + Thread.currentThread().getName() + "执行完成");
            }else if(i == 3){
                Thread.sleep(7000);
                System.out.println("线程：" + i + Thread.currentThread().getName() + "执行完成");
            }else if(i == 4){
                Thread.sleep(9000);
                System.out.println("线程：" + i + Thread.currentThread().getName() + "执行完成");
            }else if(i == 5){
                Thread.sleep(2000);
                System.out.println("线程：" + i + Thread.currentThread().getName() + "执行完成");
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
