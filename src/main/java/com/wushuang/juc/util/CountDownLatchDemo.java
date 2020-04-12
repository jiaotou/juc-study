package com.wushuang.juc.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


/**
 *CountDownLatch是Java并发包中的一种计数器，其主要解决的是让一个线程去等待其他多个线程的场景
 * 通过实现一个内部的共享变量来进行操作，主线程调用CountDownLatch的await方法来等待此计数器归零
 * 其他线程执行完任务之后调用countDown方法将计数器的数值减一，当所有线程都执行完任务之后，计数器就归零了
 * 这个时候主线程就被唤醒继续执行接下来的任务
 * 其特点是如果计数器不归零，那么主线程就需要一直等待，但是也可以设置等待时间，如果超时之后就自动中断了
 * 这种计数器的实现是不可重复的，也就是说计数器的值归零之后不会重置计数器的值
 * 应用场景：大任务分解成小任务进行多线程并发操作，主线程等小任务全部执行完成之后再执行
 * 例如：对账过程中对账文件的下载解析；游戏过程中等待加载之后再开始游戏
 *
 *
 * @author jiaotou
 */
public class CountDownLatchDemo implements Runnable{

    private List<String> outPutStringList;

    CountDownLatch countDownLatch;

    public CountDownLatchDemo(List<String> strList, CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
        this.outPutStringList = strList;
    }

    @Override
    public void run() {
        outPutStringList.add("countDown add");
        countDownLatch.countDown();
    }

    public static void main(String[] args) {
        final List<String> stringList = Collections.synchronizedList(new ArrayList<String>());
        CountDownLatch countDownLatch = new CountDownLatch(11);
        try{
            List<Thread> workers = Stream.generate(() -> new Thread(new CountDownLatchDemo(stringList, countDownLatch)))
                    .limit(10)
                    .collect(toList());
            workers.forEach(Thread::start);
            countDownLatch.await(1000L, TimeUnit.MILLISECONDS);
            stringList.add("end countDown");
            System.out.println(stringList.toString());
        }catch (InterruptedException e){
            e.printStackTrace();
            System.out.println(e);
        }


    }
}
