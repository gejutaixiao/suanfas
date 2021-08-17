package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.listNode.ListNode;

public class _61 {

    //旋转链表
    //给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) {
            return head;
        }
        int num = 0;
        ListNode cur = head;
        while (cur != null) {
            num++;
            cur = cur.next;
        }
        k = num - k % num;
        cur = head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;
        while(k > 0) {
            head = head.next;
            k--;
        }
        cur = head;
        while(num > 1) {
            cur = cur.next;
            num--;
        }
        cur.next = null;
        return head;
    }
}
