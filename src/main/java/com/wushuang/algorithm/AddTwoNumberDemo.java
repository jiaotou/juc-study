package com.wushuang.algorithm;

import com.wushuang.base.ListNode;

/**
 * 两数相加
 * 将两个链表看成是相同长度的进行遍历，如果一个链表较短则在前面补 00，比如 987 + 23 = 987 + 023 = 1010
 * 每一位计算的同时需要考虑上一位的进位问题，而当前位计算结束后同样需要更新进位值
 * 如果两个链表全部遍历完毕后，进位值为 11，则在新链表最前方添加节点 11
 * 小技巧：对于链表问题，返回结果为头结点时，通常需要先初始化一个预先指针 pre，该指针的下一个节点指向真正的头结点head。
 * 使用预先指针的目的在于链表初始化时无可用节点值，而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果。
 *
 * @author <a href="jiaotou@2dfire.com">jiaotou</a>
 * @date 2020/6/18 10:53
 */
public class AddTwoNumberDemo {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 预先指针
        ListNode pre = new ListNode(0);
        // 将当前节点指向预先节点
        ListNode cur = pre;
        // 计算进位
        int carry = 0;
        // 循环遍历两个链表
        while (l1 != null || l2 != null) {
            // 取链表的值，为空则补零
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            // 求两个节点值的和再加上进位
            int sum = x + y + carry;

            // 重新计算进位
            carry = sum / 10;
            // 计算当前位置的真实值
            sum = sum % 10;
            // 将当前位置的值插入链表
            cur.next = new ListNode(sum);

            // 将当前节点指向下一个节点,平滑移动节点cur
            cur = cur.next;
            // 平行移动链表
            if (l1 != null) {
                l1 = l1.next;
            }
            // 平行移动链表
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // 遍历完成之后如果进位值为1
        if (carry == 1) {
            // 将最后的进位放进链表
            cur.next = new ListNode(carry);
        }
        // 返回结果
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(7);
        listNode.next = new ListNode(8);
        listNode.next.next = new ListNode(9);

        ListNode listNode1 = new ListNode(3);
        listNode1.next = new ListNode(2);

        ListNode result = addTwoNumbers(listNode, listNode1);
        System.out.println("" + result.toString());
    }

}
