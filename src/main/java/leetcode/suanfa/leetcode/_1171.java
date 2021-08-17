package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.listNode.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _1171 {

    //从链表中删去总和为0的连续代码
    /**
     * 给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
     *
     * 删除完毕后，请你返回最终结果链表的头节点。
     *
     * 你可以返回任何满足题目要求的答案。
     *
     * （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。）
     *
     */

    /**
     * 输入：head = [1,2,3,-3,-2]
     * 输出：[1]
     *
     * 输入：head = [1,2,3,-3,4]
     * 输出：[1,2,4]
     */
    public static ListNode removeZeroSumSublists(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode pre = new ListNode(-1);
        HashMap<Integer, ListNode> map = new HashMap<>();
        pre.next = head;
        int sum = 0;
        for(ListNode d = pre; d != null; d = d.next) {
            sum += d.val;
            map.put(sum, d);
        }
        sum = 0;
        for(ListNode d = pre; d != null; d = d.next) {
            sum += d.val;
            if(map.containsKey(sum)) {
                d.next = map.get(sum).next;
            }
        }
        return pre.next;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(-3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(-5);
        ListNode node8 = new ListNode(5);
        ListNode node9 = new ListNode(7);
        ListNode node10 = new ListNode(5);
        l1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;

        ListNode listNode = removeZeroSumSublists(l1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
