package com.wushuang.algorithm;

/**
 * 斐波拉契数列实现代码
 *
 * @author <a href="jiaotou@2dfire.com">jiaotou</a>
 * @date 2020/4/9 11:14
 */
public class FibonacciSequenceDemo {

    private static int getFiBo(int i) {
        if (i == 1 || i == 2) {
            return 1;
        }
        return getFiBo(i - 1) + getFiBo(i - 2);
    }

    public static void main(String[] args) {
        int count = 20;
        System.out.println("斐波拉契数列的前" + count + "项数据为:");
        for (int i = 1; i <= count; i++) {
            System.out.print(getFiBo(i) + ";");

        }
    }
}
