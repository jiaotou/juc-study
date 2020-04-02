package com.wushuang.pattern.singleton;

/**
 * 单例模式 饿汉模式写法 线程安全，比较常用，但是容易产生垃圾，因为一开始就初始化
 *
 * @author <a href="jiaotou@2dfire.com">jiaotou</a>
 * @date 2020/4/2 14:58
 */
public class Singleton2 {

    private static Singleton2 instance = new Singleton2();

    private Singleton2() {

    }

    public static Singleton2 getInstance() {
        return instance;
    }
}
