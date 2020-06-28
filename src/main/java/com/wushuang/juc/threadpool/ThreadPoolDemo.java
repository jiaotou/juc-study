package com.wushuang.juc.threadpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="jiaotou@2dfire.com">jiaotou</a>
 * @date 2020/4/13 18:52
 */
public class ThreadPoolDemo {

    private final static Logger LOGGER = LoggerFactory.getLogger(ThreadPoolDemo.class);

    public static void main(String[] args) throws InterruptedException {

        ExecutorService execute = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());

        execute.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("=====11=======");
            }
        });

        TimeUnit.SECONDS.sleep(5);


        execute.execute(new Run1());

        TimeUnit.SECONDS.sleep(5);
        //
        execute.execute(new Run2());
        execute.shutdown();

    }


    private static class Run1 implements Runnable {

        @Override
        public void run() {
            int count = 0;
            while (true) {
                count++;
                System.out.println("-------222-------------{}" + count);
                if (count == 10) {
                    try {
                        System.out.println(1 / 0);
                    } catch (Exception e) {
                        System.out.println("Exception" + e);
                    }
                }

                if (count == 20) {
                    System.out.println("count={}" + count);
                    break;
                }
            }
        }
    }

    private static class Run2 implements Runnable {

        public Run2() {
            System.out.println("run2 构造函数");
        }

        @Override
        public void run() {
            System.out.println("run222222222");
        }
    }
}
