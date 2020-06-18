package com.wushuang.algorithm;

import com.wushuang.base.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 两数之和 2
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 题意分析：
 * (1) 给定两个非空链表表示非负整数，也就是不用考虑符号的加法运算。
 * (2) 链表头节点表示数字的高位，加法运算需要从低位算起考虑进位。
 * (3) 每个节点只存储一位数字，表示每位都是个位数相加。
 * 解题思路：
 * (1) 两个个位数相加最大不会超过18(即9 + 9)，前一位相加的进位只会是1或者0。
 * (2) 每位相加后存的值为前一位进位的值和当前位两数的和sum % 10,需要进位的值curr = sum/10。
 * (3) 遍历完两个链表后，判断是否有进位值，如果有就存到新链表的开始。
 *
 * @author <a href="jiaotou@2dfire.com">jiaotou</a>
 * @date 2020/6/18 19:37
 */
public class AddTwoNumbersDemo {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> s1 = new ArrayList<>();
        List<Integer> s2 = new ArrayList<>();
        // 首先将链表存入列表
        while (l1 != null) {
            s1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.add(l2.val);
            l2 = l2.next;
        }
        ListNode p = null;
        // 初始化进位
        int curr = 0;
        // 遍历两个列表，从尾部往前遍历
        for (int sl1 = s1.size() - 1, sl2 = s2.size() - 1; sl1 >= 0 || sl2 >= 0; sl1--, sl2--) {
            int sum = 0;
            // 如果存在值,那么进行相加
            if (sl1 >= 0) {
                sum = sum + s1.get(sl1);
            }
            // 如果存在值,那么进行相加
            if (sl2 >= 0) {
                sum = sum + s2.get(sl2);
            }
            // 如果进位大于零,那么加上进位
            if (curr > 0) {
                sum = sum + curr;
            }
            // 将目标值插入链表
            ListNode sumNode = new ListNode(sum % 10);
            sumNode.next = p;
            p = sumNode;
            // 重新计算进位
            curr = sum / 10;
        }
        // 循环完毕如果进位大于零,将最高位的进位插入链表
        if (curr > 0) {
            ListNode sumNode = new ListNode(curr);
            sumNode.next = p;
            p = sumNode;
        }
        return p;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(7);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(4);
        listNode.next.next.next = new ListNode(3);

        ListNode listNode1 = new ListNode(5);
        listNode1.next = new ListNode(6);
        listNode1.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(listNode, listNode1);
        System.out.println("" + result.toString());
    }

}
