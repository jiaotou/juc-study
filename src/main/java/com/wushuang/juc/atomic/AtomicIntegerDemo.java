package com.wushuang.juc.atomic;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 原子操作类AtomicInteger
 *
 * @author jiaotou
 */
public class AtomicIntegerDemo implements Runnable{

    AtomicInteger integer;
     public AtomicIntegerDemo(AtomicInteger atomicInteger){
         this.integer = atomicInteger;
     }

    @Override
    public void run() {
        for(int i = 1; i <= 1000; i++){
            integer.addAndGet(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger();
        List<Thread> workers = Stream.
                generate(()->new Thread(new AtomicIntegerDemo(atomicInteger))).limit(10).collect(Collectors.toList());
        workers.forEach(Thread::start);
        for(Thread worker : workers){
            worker.join();
        }

        System.out.println("结果为" + atomicInteger.get());
    }
}
