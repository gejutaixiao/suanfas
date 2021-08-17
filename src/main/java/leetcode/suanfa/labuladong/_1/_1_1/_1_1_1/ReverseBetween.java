package leetcode.suanfa.labuladong._1._1_1._1_1_1;

import leetcode.suanfa.labuladong._1.Node;

public class ReverseBetween {

    //递归反转给定区间的链表
    //现在解决我们最开始提出的问题，给一个索引区间 [m,n]（索引从 1 开始），仅仅反转区间中的链表元素。
    Node successor;
    public Node reverseBetween(Node head, int m, int n) {
        if(m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    public Node reverseN(Node head, int n) {
        if(n == 1) {
            successor = head.next;
            return head;
        }
        Node last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
}
