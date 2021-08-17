package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.listNode.ListNode;

public class _Offer18 {

    //删除链表的节点
    //给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
    //返回删除后的链表的头节点。

    public ListNode deleteNode(ListNode head, int val) {
        if(head == null) {
            return null;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode cur = pre;
        while(cur.next != null) {
            if(cur.next.val == val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return pre.next;
    }
}
