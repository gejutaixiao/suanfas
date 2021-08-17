package leetcode.suanfa.labuladong._1._1_4._1_4_3;

import leetcode.suanfa.labuladong._1.Node;

public class HasCycle {

    //环形链表
    public boolean hasCycle(Node head) {
        if(head == null) {
            return false;
        }
        Node slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true;
            }
        }
        return false;
    }
}
