package com.wushuang.juc.code2;

/**
 * @author <a href="jiaotou@2dfire.com">jiaotou</a>
 * @date 2020/3/20 16:12
 */
public class SynchronizedTest {

    public synchronized void method1() {
        System.out.println("Method1 start");
        try {
            System.out.println("Method1 Execute");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method1 end");
    }

    public synchronized void method2() {
        System.out.println("Method2 start");
        try {
            System.out.println("Method2 Execute");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method2 end");
    }

    public static void main(String[] args) {
        final SynchronizedTest test = new SynchronizedTest();
        new Thread(new Runnable() {
            public void run() {
                test.method1();
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                test.method2();
            }
        }).start();
    }
}
