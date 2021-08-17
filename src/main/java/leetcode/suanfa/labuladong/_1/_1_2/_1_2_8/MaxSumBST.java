package leetcode.suanfa.labuladong._1._1_2._1_2_8;

import leetcode.suanfa.leetcode.treenode.TreeNode;

public class MaxSumBST {

    //二叉搜索子树的最大键值和
    //题目会给你输入一棵二叉树，这棵二叉树的子树中可能包含二叉搜索树对吧，请你找到节点之和最大的那棵二叉搜索树，返回它的节点值之和。
    int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        traverse(root);
        return maxSum;
    }

    //数组第nums[0]代表该树是否为BST
    //nums[1]代表该树中的最小值
    //nums[2]代表该树中的最大值
    //nums[3]代表该书的所有结点之和
    public int[] traverse(TreeNode root) {
        if(root == null) {
            return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        int[] left = traverse(root.left);
        int[] right = traverse(root.right);
        int[] res = new int[4];
        if(left[0] == 1 && right[0] == 1 && root.val > left[2] && root.val < right[1]) {
            //这棵树是BST
            res[0] = 1;
            //这棵BST中的最小值
            res[1] = Math.min(left[1], root.val);
            //这棵BST树中的最大值
            res[2] = Math.max(right[2], root.val);
            //这棵BST树中的所有节点之和
            res[3] = left[3] + right[3] + root.val;
            //更新全局变量
            maxSum = Math.max(maxSum, res[3]);
        } else {
            res[0] = 0;
        }
        return res;
    }
}
