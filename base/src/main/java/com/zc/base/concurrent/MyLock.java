package com.zc.base.concurrent;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class MyLock {


    class MySync extends AbstractQueuedSynchronizer{

        protected MySync() {
            super();
        }

        @Override
        protected boolean tryAcquire(int arg) {
            return super.tryAcquire(arg);
        }

        @Override
        protected boolean tryRelease(int arg) {
            return super.tryRelease(arg);
        }

        @Override
        protected int tryAcquireShared(int arg) {
            return super.tryAcquireShared(arg);
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            return super.tryReleaseShared(arg);
        }

        @Override
        protected boolean isHeldExclusively() {
            return super.isHeldExclusively();
        }
    }


}
