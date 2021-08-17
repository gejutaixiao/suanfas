package leetcode.suanfa.labuladong._1._1_4._1_4_3;

import leetcode.suanfa.labuladong._1.Node;

public class DetectCycle {

    //环形链表Ⅱ

    public Node detectCycle(Node head) {
        if(head == null) {
            return null;
        }
        Node slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                slow = head;
                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
