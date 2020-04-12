package com.wushuang.juc.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


/**
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
