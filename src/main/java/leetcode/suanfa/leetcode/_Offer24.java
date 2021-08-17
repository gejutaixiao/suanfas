package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.listNode.ListNode;

public class _Offer24 {

    //反转链表
    //定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

    public ListNode reverse1(ListNode head) {
        ListNode pre = null, next = head;
        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public ListNode reverse2(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode last = reverse2(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
