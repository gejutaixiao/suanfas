package leetcode.suanfa.labuladong._1._1_2._1_2_4;

import leetcode.suanfa.leetcode.treenode.TreeNode;

public class KthSmallest {

    //二叉搜索树中第k小的元素
    //给定一个二叉搜索树的根节点root，和一个整数k，请你设计一个算法查找其中第k的最小元素（从1开始计数）

    int res = 0;
    int index = 0;
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    public void traverse(TreeNode root, int k) {
        if(root == null) {
            return;
        }
        traverse(root.left, k);
        index++;
        if(index == k) {
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }
}
