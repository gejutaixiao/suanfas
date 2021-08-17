package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.listNode.ListNode;

import java.util.HashSet;

public class _Offer52 {

    //两个链表的第一个公共节点
    //输入两个链表，找出它们的第一个公共节点。

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = headA;
        while (cur != null) {
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

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode head1 = headA, head2 = headB;
        while(head1 != head2) {
            if(head1 != null) {
                head1 = head1.next;
            } else {
                head1 = headB;
            }
            if(head2 != null) {
                head2 = head2.next;
            } else {
                head2 = headA;
            }
        }
        return head1;
    }

    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode head1 = headA, head2 = headB;
        int len1 = 0, len2 = 0;
        while(head1 != null) {
            len1++;
            head1 = head1.next;
        }
        while(head2 != null) {
            len2++;
            head2 = head2.next;
        }
        head1 = headA;
        head2 = headB;
        if(len1 > len2) {
            while(len1 - len2 > 0) {
                head1 = head1.next;
                len1--;
            }
        } else {
            while(len2 - len1 > 0) {
                head2 = head2.next;
                len2--;
            }
        }
        while(head1 != head2) {
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1;
    }

}
