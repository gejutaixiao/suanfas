package leetcode.suanfa.labuladong._1._1_1._1_1_2;

import leetcode.suanfa.labuladong._1.Node;

public class ReverseKGroup {

    //k个一组反转链表
    public Node reverseKGroup(Node head, int k) {
        if(head == null) {
            return null;
        }
        Node a = head, b = head;
        for(int i = 0; i < k; i++) {
            if(b == null) {
                return head;
            }
            b = b.next;
        }
        Node newHead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }
    public Node reverse(Node start, Node end) {
        Node pre = null, next = start;
        while(start != end) {
            next = start.next;
            start.next = pre;
            pre = start;
            start = next;
        }
        return pre;
    }
}
