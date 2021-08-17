package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.listNode.ListNode;

public class _21 {
    //合并两个有序链表
    //将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的

    //1.递归方法
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        } else if(l2 == null) {
            return l1;
        } else if(l1.val >= l2.val) {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        }
    }

    //2.迭代方法
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
        ListNode res = pre;
        while(l1 != null && l2 != null) {
            if(l1.val >= l2.val) {
                pre.next = l2;
                l2 = l2.next;
            } else {
                pre.next = l1;
                l1 = l1.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2: l1;
        return res.next;
    }
}
