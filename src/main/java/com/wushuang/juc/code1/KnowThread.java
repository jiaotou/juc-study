package com.wushuang.juc.code1;

/**
 * 学习什么是线程demo
 *
 * @author <a href="jiaotou@2dfire.com">jiaotou</a>
 * @date 2020/3/20 13:59
 */
public class KnowThread {

    static class ThreadA extends Thread {
        @Override
        public void run() {
            System.out.println(getName() + "运行");
        }
    }

    static class ThreadB implements Runnable {
        public void run() {
            System.out.println(Thread.currentThread().getName() + "运行");
        }
    }

    public static void main(String[] args) {
        ThreadA a = new ThreadA();
        ThreadB b = new ThreadB();
        System.out.println(Thread.currentThread().getName() + "运行");
        try {
            a.start();
            a.sleep(50000);
            a.join();
            new Thread(b).start();
        } catch (InterruptedException e) {
        }
        System.out.println(Thread.currentThread().getName() + "运行");
    }
}
