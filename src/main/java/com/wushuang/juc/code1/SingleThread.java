package com.wushuang.juc.code1;

/**
 * 单线程模型，此时只有main线程在运行
 *
 * @author jiaotou
 */
public class SingleThread {

    public static void main(String[] args) {
        for(int i = 0; i <= 1000; i ++){
            System.out.print(i + "");
        }
    }
}
