package com.zc.netty.demo;

import io.netty.util.concurrent.*;

public class PromiseDemo {

    public static void main(String[] args) {

        EventExecutor eventExecutor = new DefaultEventExecutor();

        Promise promise = new DefaultPromise(eventExecutor);

        promise.addListener(new GenericFutureListener<Future<Integer>>() {
            @Override
            public void operationComplete(Future future) throws Exception {
                if(future.isSuccess()){
                    System.out.println("任务成功，结果：" + future.get());
                }else {
                    System.out.println("任务失败，异常：" + future.cause());
                }
            }
        }).addListener(new GenericFutureListener<Future<Integer>>() {
            @Override
            public void operationComplete(Future future) throws Exception {
                System.out.println("任务结束。。。。");
            }
        });

        eventExecutor.submit(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            promise.setSuccess("任务成功");
            promise.setFailure(new RuntimeException("任务失败"));
        });

        try {
//            promise.sync();
            promise.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
