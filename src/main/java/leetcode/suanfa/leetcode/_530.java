package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.treenode.TreeNode;

public class _530 {

    //二叉搜索树的最小绝对差
    //https://leetcode-cn.com/tag/tree/problemset/
    /**
     * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
     */

    int pre;
    int min;
    public int getMinimumDifference(TreeNode root) {
        pre = -1;
        min = Integer.MAX_VALUE;
        traverse(root);
        return min;
    }

    private void traverse(TreeNode root) {
        if(root == null) {
            return;
        }
        traverse(root.left);
        if(pre == -1) {
            pre = root.val;
        } else {
            min = Math.min(min, root.val - pre);
            pre = root.val;
        }
        traverse(root.right);
    }
}
