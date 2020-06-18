package com.wushuang.algorithm;

import com.wushuang.base.ListNode;

/**
 * 链表反转
 * (1) 反转链表就是把链表所有节点指向下一个节点的指针next指向它的前一个节点。
 * (2) 直至遍历完所有节点，则链表反转完成。
 *
 * @author <a href="jiaotou@2dfire.com">jiaotou</a>
 * @date 2020/6/18 18:37
 */
public class ReverseListDemo {

    public static ListNode reverseList(ListNode head) {
        // 判断传入节点为空或者只有一个节点，则直接返回。
        if (head == null || head.next == null) {
            return head;
        }
        // 预先创建一个节点用来记录每个节点的前一个节点。
        ListNode pre = null;
        // 遍历链表的每个节点，将 next 指向前一个节点。。
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

    /**
     * (1) 反转后第一个节点就是之前链表的最后一个节点(next指针指向null)
     * (2) 反转后每个节点被自己的下一个节点的 next 指向。
     * (3) 直至递归遍历完所有节点，则链表完成反转。
     *
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        // 如果当前节点为空或者是链表的最后一个节点，则直接返回。
        if (head == null || head.next == null) {
            return head;
        }
        // 递归反转每个节点指向。
        ListNode p = reverseList1(head.next);
        // 将每个节点的下一个节点的 next 指向自己完成反转。
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(7);
        listNode.next = new ListNode(8);
        listNode.next.next = new ListNode(9);

        ListNode result = reverseList(listNode);
        System.out.println("" + result.toString());

        ListNode result1 = reverseList1(listNode);
        System.out.println("" + result1.toString());
    }

}
