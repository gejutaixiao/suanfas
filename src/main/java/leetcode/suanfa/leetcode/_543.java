package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.treenode.TreeNode;

public class _543 {

    //二叉树的直径
    //https://leetcode-cn.com/tag/tree/problemset/
    /**
     * 给定一棵二叉树，你需要计算它的直径长度。
     * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
     */

    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }
    public int depth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
