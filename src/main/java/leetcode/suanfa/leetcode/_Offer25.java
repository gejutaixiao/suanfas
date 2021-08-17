package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.listNode.ListNode;

public class _Offer25 {

    //合并两个排序的链表
    //输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

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

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        while(l1 != null && l2 != null) {
            if(l1.val >= l2.val) {
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return pre.next;
    }
}
