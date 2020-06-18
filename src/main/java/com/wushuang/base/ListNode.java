package com.wushuang.base;

import java.io.Serializable;

/**
 * 基础数据结构 链表
 *
 * @author <a href="jiaotou@2dfire.com">jiaotou</a>
 * @date 2020/6/18 10:54
 */
public class ListNode implements Serializable {

    /**
     * 链表值
     */
    public int val;

    /**
     * 下一个节点
     */
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString(){
        ListNode temp = this;
        String s = "";
        while (temp != null){
            s = s + temp.val;
            temp = temp.next;
        }
        return s;
    }
}
