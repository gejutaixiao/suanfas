package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.listNode.ListNode;
import leetcode.suanfa.leetcode.treenode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _1367 {

    //二叉树中的链表
    /**
     * 给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表。
     *
     * 如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以 head 为首的链表中每个节点的值，那么请你返回 True ，否则返回 False 。
     *
     * 一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径。
     *
     */
    public boolean isSubPath(ListNode head, TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Stack<Boolean> stack = new Stack<>();
        while(!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if(tmp.val == head.val) {
                stack.push(bulid(head, tmp));
            }
            if(tmp.left != null) {
                queue.add(tmp.left);
            }
            if(tmp.right != null) {
                queue.add(tmp.right);
            }
        }
        while(!stack.isEmpty()) {
            if(stack.pop() == true) {
                return true;
            }
        }
        return false;
    }
    public boolean bulid(ListNode head, TreeNode root) {
        if(head == null && root == null) {
            return true;
        }
        if(root == null && head != null) {
            return false;
        }
        if(head == null && root != null) {
            return true;
        }
        if(head.val != root.val) {
            return false;
        }
        return bulid(head.next, root.left) || bulid(head.next, root.right);
    }
}
