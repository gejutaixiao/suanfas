package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.listNode.ListNode;

public class _mian0202 {

    //返回倒数第k个结点的值
    public int kthToLast(ListNode head, int k) {
        ListNode cur = head;
        for(int i = 1; i < k; i++) {
            cur = cur.next;
        }
        while(cur.next != null) {
            cur = cur.next;
            head = head.next;
        }
        return head.val;
    }
}
