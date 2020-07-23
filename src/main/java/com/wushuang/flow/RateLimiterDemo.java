package com.wushuang.flow;

import com.google.common.util.concurrent.RateLimiter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="jiaotou@2dfire.com">jiaotou</a>
 * @date 2020/7/23 16:29
 */
public class RateLimiterDemo {

    public static void main(String[] args) {
        RateLimiterDemo test = new RateLimiterDemo();
        // 正常速率
        //test.testAcquire();
        // 突发速率
        //testNoNormalAcquire();
        testNoNormalAcquire1();
    }

    public static void testAcquire() {
        RateLimiter limiter = RateLimiter.create(10);
        for (int i = 1; i < 100; i++) {
            double waitTime = limiter.acquire();
            System.out.println("cutTime=" + longToDate(System.currentTimeMillis()) + " acq:" + i + " waitTime:" + waitTime);
        }
    }

    public static void testNoNormalAcquire() {
        RateLimiter limiter = RateLimiter.create(5);
        for (int i = 1; i < 5; i++) {
            double waitTime = 0;
            if (i == 2) {
                waitTime = limiter.acquire(20);
            } else {
                waitTime = limiter.acquire(1);
            }
            System.out.println("cutTime=" + longToDate(System.currentTimeMillis()) + " acq:" + i + " waitTime:" + waitTime);
        }
    }

    public static void testNoNormalAcquire1() {
        RateLimiter limiter = RateLimiter.create(5, 10000, TimeUnit.MILLISECONDS);
        for (int i = 1; i < 10; i++) {
            System.out.println("waitTime:" + limiter.acquire(10));
        }

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 1; i < 10; i++) {
            System.out.println(limiter.acquire(5));
        }
    }

    public static String longToDate(long lo) {
        Date date = new Date(lo);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sd.format(date);
    }
}
