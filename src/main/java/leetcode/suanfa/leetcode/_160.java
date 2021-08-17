package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.listNode.ListNode;

import java.util.HashSet;

public class _160 {

    //相交链表
    //编写一个程序，找到两个单链表相交的起始节点。

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = headA;
        while(cur != null) {
            set.add(cur);
            cur = cur.next;
        }
        cur = headB;
        while(cur != null) {
            if(set.contains(cur)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
}
