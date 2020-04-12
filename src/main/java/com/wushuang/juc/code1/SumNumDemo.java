package com.wushuang.juc.code1;

import java.util.concurrent.CountDownLatch;

public class SumNumDemo {

    public static int[] sum = new int[5];

    public int getTotalSum() {
        int total = 0;
        for (int ss : sum) {
            total = total + ss;
        }
        return total;
    }

    static class ThreadA extends Thread {

        CountDownLatch countDownLatch;

        public ThreadA(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;

        }

        @Override
        public void run() {
            for (int i = 1; i <= 2000; i++) {
                sum[0] = sum[0] + i;
            }
            countDownLatch.countDown();
        }
    }

    static class ThreadB extends Thread {


        CountDownLatch countDownLatch;

        public ThreadB(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;

        }

        @Override
        public void run() {
            for (int i = 2001; i <= 4000; i++) {
                sum[1] = sum[1] + i;
            }
            countDownLatch.countDown();
        }
    }

    static class ThreadC extends Thread {

        CountDownLatch countDownLatch;
        public ThreadC(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;

        }

        @Override
        public void run() {
            for (int i = 4001; i <= 6000; i++) {
                sum[2] = sum[2] + i;
            }
            countDownLatch.countDown();
        }
    }

    static class ThreadD extends Thread {

        CountDownLatch countDownLatch;

        public ThreadD(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;

        }

        @Override
        public void run() {
            for (int i = 6001; i <= 8000; i++) {
                sum[3] = sum[3] + i;
            }
            countDownLatch.countDown();
        }
    }

    static class ThreadE extends Thread {

        CountDownLatch countDownLatch;

        public ThreadE(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;

        }

        @Override
        public void run() {
            for (int i = 8001; i <= 10000; i++) {
                sum[4] = sum[4] + i;
            }
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SumNumDemo sumNumDemo = new SumNumDemo();
        CountDownLatch countDownLatch = new CountDownLatch(5);
        ThreadA t1 = new ThreadA(countDownLatch);
        ThreadB t2 = new ThreadB(countDownLatch);
        ThreadC t3 = new ThreadC(countDownLatch);
        ThreadD t4 = new ThreadD(countDownLatch);
        ThreadE t5 = new ThreadE(countDownLatch);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        countDownLatch.await();
        System.out.println("结果为" + sumNumDemo.getTotalSum());
    }
}
