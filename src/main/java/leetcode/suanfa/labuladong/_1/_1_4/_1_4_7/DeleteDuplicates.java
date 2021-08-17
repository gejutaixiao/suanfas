package leetcode.suanfa.labuladong._1._1_4._1_4_7;

import leetcode.suanfa.labuladong._1.Node;

public class DeleteDuplicates {

    //删除排序链表中重复出现的元素
    public Node deleteDuplicates(Node head) {
        if(head == null) {
            return null;
        }
        Node slow = head, fast = head;
        while(fast != null) {
            if(slow.val != fast.val) {
                slow.next = fast.next;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }
}
