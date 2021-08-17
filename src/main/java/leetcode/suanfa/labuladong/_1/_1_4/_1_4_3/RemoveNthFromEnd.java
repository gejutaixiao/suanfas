package leetcode.suanfa.labuladong._1._1_4._1_4_3;

import leetcode.suanfa.labuladong._1.Node;

public class RemoveNthFromEnd {

    //删除链表的倒数第N个节点
    public Node removeNthFromEnd(Node head, int n) {
        Node slow = head, fast = head;
        while(n-- > 0) {
            fast = fast.next;
        }
        if(fast == null) {
            return head.next;
        }
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
