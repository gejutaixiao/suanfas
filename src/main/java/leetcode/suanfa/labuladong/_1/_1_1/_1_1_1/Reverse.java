package leetcode.suanfa.labuladong._1._1_1._1_1_1;

import leetcode.suanfa.labuladong._1.Node;

public class Reverse {

    //递归反转整个链表

    public Node reverse(Node head) {
        if(head == null) {
            return head;
        }
        Node last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
