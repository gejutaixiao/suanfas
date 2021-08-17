package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.listNode.ListNode;

import java.util.*;

public class _1019 {

    //链表中下一个更大的结点
    /**
     * 给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
     *
     * 每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.val，那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。
     *
     * 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。
     *
     * 注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，其头节点的值为 2，第二个节点值为 1，第三个节点值为 5 。
     * 输入：[2,1,5]
     * 输出：[5,5,0]
     *
     * 输入：[2,7,4,3,5]
     * 输出：[7,0,5,5,0]
     */

    public static int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while(cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int[] res = new int[list.size()];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < list.size(); i++) {
            while(!stack.isEmpty() && list.get(i) > list.get(stack.peek())) {
                res[stack.pop()] = list.get(i);
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(9);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(9);
        ListNode node8 = new ListNode(4);
        ListNode node9 = new ListNode(3);
        ListNode node10 = new ListNode(2);
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
        int[] ints = nextLargerNodes(l1);
        for(int i : ints) {
            System.out.println(i);
        }
//        while(!ints.isEmpty()) {
//            System.out.println(ints.remove());
//        }
    }
}
