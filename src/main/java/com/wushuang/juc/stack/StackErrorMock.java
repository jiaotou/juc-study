package com.wushuang.juc.stack;

/**
 * 栈内存溢出测试源码
 *
 * @author <a href="jiaotou@2dfire.com">jiaotou</a>
 * @date 2020/4/2 14:38
 */
public class StackErrorMock {

    private static int index = 1;

    public void call() {
        index++;
        call();
    }

    public static void main(String[] args) {
        StackErrorMock mock = new StackErrorMock();
        try {
            mock.call();
        } catch (Throwable e) {
            System.out.println("Stack deep:" + index);
            e.printStackTrace();
        }
    }
}
