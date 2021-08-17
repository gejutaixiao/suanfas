package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.treenode.TreeNode;

public class _110 {

    //平衡二叉树
    //https://leetcode-cn.com/tag/tree/problemset/
    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     *
     * 本题中，一棵高度平衡二叉树定义为：
     *
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
     *
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：true
     */

    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        return Math.abs(rightDepth - leftDepth) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    public int depth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}
