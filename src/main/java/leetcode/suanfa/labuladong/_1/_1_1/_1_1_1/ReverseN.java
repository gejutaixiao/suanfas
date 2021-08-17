package leetcode.suanfa.labuladong._1._1_1._1_1_1;

import leetcode.suanfa.labuladong._1.Node;

public class ReverseN {

    //递归反转链表的前N个节点
    Node successor;

    public Node reverseN(Node head, int N) {
        if(N == 1) {
            //记录第N+1个节点
            successor = head.next;
            return head;
        }
        //递归反转head.next的前N - 1个节点
        Node last = reverseN(head.next, N - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
}
