package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.listNode.ListNode;

import java.util.Stack;

public class _445 {

    //两数相加Ⅱ
    public static ListNode addTwoListNodes(ListNode l1, ListNode l2) {
        long sum1 = 0, sum2 = 0;
        while(l1 != null) {
            sum1 = sum1 * 10 + l1.val;
            l1 = l1.next;
        }
        while(l2 != null) {
            sum2 = sum2 * 10 + l2.val;
            l2 = l2.next;
        }
        String str = String.valueOf(sum1 + sum2);
        ListNode res = new ListNode(-1);
        ListNode pre = res;
        for(int i = 0; i < str.length(); i++) {
            pre.next = new ListNode(Integer.parseInt(String.valueOf(str.charAt(i))));
            pre = pre.next;
        }
        return res.next;
    }

    public static ListNode addTwoListNodes2(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while(l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int add = 0;
        ListNode res = null;
        while(!stack1.isEmpty() || !stack2.isEmpty() || add != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = a + b + add;
            add = sum / 10;
            ListNode cur = new ListNode(sum % 10);
            cur.next = res;
            res = cur;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(9);
        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(9);
        ListNode node7 = new ListNode(9);
        ListNode node8 = new ListNode(9);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(9);
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

        ListNode l2 = new ListNode(7);
        node10.next = new ListNode(9);
        ListNode listNode = addTwoListNodes2(l1, l2);
        while(listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
