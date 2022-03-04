package com.zc.base.concurrent.lock;

import com.google.common.collect.Range;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Generator {

    private Lock lock = new ReentrantLock();

    private final static AtomicInteger start = new AtomicInteger(100000);
    private final static AtomicInteger end = new AtomicInteger(110000);

    private Sequence sequence;

    public Long nextId(){

        if(sequence != null){
            Long id = sequence.get();
            if(id != null){
                return id;
            }
        }

        lock.lock();
        try {
            if(sequence != null){
                Long id = sequence.get();
                if(id != null){
                    return id;
                }
            }

            LocalDateTime now = LocalDateTime.now();
            if(sequence != null){
                LocalDateTime time = sequence.getTime();
            }

        }finally {
            lock.unlock();
        }

        return null;


    }

    @Setter @Getter
    private class Sequence{

        private AtomicInteger cur;

        private Range range;

        private LocalDateTime time;

        public Sequence(AtomicInteger cur, Range range, LocalDateTime time) {
            this.cur = cur;
            this.range = range;
            this.time = time;
        }

        public Long get(){
            int next = cur.incrementAndGet();
            if(range.contains(next)){
                return Long.parseLong(time.format(DateTimeFormatter.ofPattern("yyMMddHHmm")) + next);
            }else {
                return null;
            }
        }

    }


}
