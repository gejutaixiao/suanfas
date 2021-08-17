package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.treenode.TreeNode;

public class _104 {

    //二叉树的最大深度
    //https://leetcode-cn.com/tag/tree/problemset/
    /**
     * 给定一个二叉树，找出其最大深度。
     *
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 给定二叉树 [3,9,20,null,null,15,7]，返回它的最大深度 3 。
     */

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return depth(root);
    }
    public int depth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}
