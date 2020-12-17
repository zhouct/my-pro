package com.zc.base.concurrent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Mutex implements Lock, Serializable {

    private final Sync sync = new Sync();

    private static class Sync extends AbstractQueuedSynchronizer{

        /**
         * 尝试获取锁，如获取成功，会设置当前线程设置为当前获取锁的线程
         * @param acquires 当前线程尝试获取锁的次数，只能为1
         * @return 成功获取锁，返回true，否则返回false
         */
        @Override
        protected boolean tryAcquire(int acquires) {
            assert acquires == 1;
            if(compareAndSetState(0, 1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        /**
         * 尝试释放锁
         * @param releases 当前线程尝试释放锁的次数，只能为1
         * @return
         */
        @Override
        protected boolean tryRelease(int releases) {
            assert releases == 1;
            if(getState() == 0){
                throw new IllegalMonitorStateException("监听锁状态异常");
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        /**
         * 当前锁是否被占用
         * @return
         */
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        /**
         * 条件队列
         * @return
         */
        Condition newCondition(){
            return new ConditionObject();
        }

        /**
         * 反序列化
         * @param inputStream
         * @throws IOException
         * @throws ClassNotFoundException
         */
        private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
            inputStream.readObject();
            setState(0);
        }
    }

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

    public boolean isLocked(){
        return sync.isHeldExclusively();
    }

    public boolean hasQueuedThread(){
        return sync.hasQueuedThreads();
    }
}
