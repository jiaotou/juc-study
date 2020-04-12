package com.wushuang.juc.util;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * CyclicBarrier是循环屏障的意思，内部实现是可重入锁ReentrantLock来控制的
 * 当线程调用其await方法表示此线程已经完成任务需要等待其他线程执行
 * 只有当其他线程都已经执行完毕，则开始执行接下来的任务
 * 和CountDownLatch的区别在于，countDownLatch计数器只能使用一次，而CyclicBarrier可以重复使用
 * 可以调用reset方法进行计数的重置
 * CountDownLatch是减计数方式，计数==0时释放所有等待的线程；CyclicBarrier是加计数方式，计数达到构造方法中参数指定的值时释放所有等待的线程
 *
 * @author jiaotou
 */
public class CyclicBarrierDemo implements Runnable{

    private CyclicBarrier cyclicBarrier;

    public CyclicBarrierDemo(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000L);
            System.out.println(Thread.currentThread().getName() + "执行任务完成,等待其他任务执行");
            cyclicBarrier.await();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
        List<Thread> workers = Stream.
                generate(() -> new Thread(new CyclicBarrierDemo(cyclicBarrier))).limit(4).collect(toList());
        workers.forEach(Thread::start);
        cyclicBarrier.await();
        System.out.println("任务完成继续");
    }
}
