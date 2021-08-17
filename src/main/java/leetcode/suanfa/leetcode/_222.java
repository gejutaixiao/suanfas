package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.treenode.TreeNode;

public class _222 {

    //完全二叉树的节点个数
    //https://leetcode-cn.com/tag/tree/problemset/

    /**
     * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
     *
     * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。
     * 若最底层为第 h 层，则该层包含 1~ 2h 个节点。
     *
     */

    public int countsNode(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int lh = 1;
        TreeNode cur = root;
        while(cur.left != null) {
            lh++;
            cur = cur.left;
        }
        int rh = 1;
        cur = root;
        while(cur.right != null) {
            rh++;
            cur = cur.right;
        }
        if(lh == rh) {
            return (int)Math.pow(2, lh) - 1;
        }
        return 1 + countsNode(root.left) + countsNode(root.right);
    }
}
