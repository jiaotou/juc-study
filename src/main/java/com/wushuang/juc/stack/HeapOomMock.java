package com.wushuang.juc.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆内存溢出测试
 *
 * @author <a href="jiaotou@2dfire.com">jiaotou</a>
 * @date 2020/4/2 14:42
 */
public class HeapOomMock {

    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<byte[]>();
        int i = 0;
        boolean flag = true;
        while (flag) {
            try {
                i++;
                //每次增加一个1M大小的数组对象
                list.add(new byte[1024 * 1024]);
            } catch (Throwable e) {
                e.printStackTrace();
                flag = false;
                //记录运行的次数
                System.out.println("count=" + i);
            }
        }
    }
}
