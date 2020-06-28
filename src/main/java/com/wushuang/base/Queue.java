package com.wushuang.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 队列
 *
 * @author <a href="jiaotou@2dfire.com">jiaotou</a>
 * @date 2020/6/19 17:31
 */
public class Queue {

    /**
     * 存放数据的列表
     */
    private List<Integer> data;

    private int p_start;

    public Queue() {
        data = new ArrayList<>();
        p_start = 0;
    }

    /**
     * 入队
     *
     * @param x
     * @return
     */
    public boolean enQueue(int x) {
        data.add(x);
        return true;
    }

    /**
     * 出队
     *
     * @return
     */
    public boolean deQueue() {
        if (isEmpty() == true) {
            return false;
        }
        p_start++;
        return true;
    }

    public int front() {
        return data.get(p_start);
    }

    public boolean isEmpty() {
        return p_start >= data.size();
    }
}
