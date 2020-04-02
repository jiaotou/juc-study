package com.wushuang.pattern.singleton;

/**
 * 单例模式 双重检查锁模式 线程安全 延迟初始化，这种方式采用双锁机制，安全且在多线程情况下能保持高性能
 *
 * @author <a href="jiaotou@2dfire.com">jiaotou</a>
 * @date 2020/4/2 15:09
 */
public class Singleton3 {
    private volatile static Singleton3 instance;

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        if (instance == null) {
            synchronized (Singleton3.class) {
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}
