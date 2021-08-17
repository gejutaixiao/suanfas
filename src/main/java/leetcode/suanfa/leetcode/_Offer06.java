package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.listNode.ListNode;

import java.util.List;

public class _Offer06 {

    //从尾到头打印链表
    //输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

    public static int[] reversePrint(ListNode head) {
        if(head == null) {
            return new int[0];
        }
        int len = 0;
        ListNode pre = null;
        ListNode next = head;
        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
            len++;
        }
        int[] res = new int[len];
        for(int i = 0; i < len; i++) {
            res[i] = pre.val;
            pre = pre.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = new ListNode(4);
        for(int i : reversePrint(node1)) {
            System.out.print(i + " ");
        }
    }

}
