package leetcode.suanfa.leetcode;

import javafx.scene.input.Mnemonic;
import leetcode.suanfa.leetcode.treenode.TreeNode;

public class _111 {

    //二叉树的最小深度
    //https://leetcode-cn.com/tag/tree/problemset/
    /**
     * 给定一个二叉树，找出其最小深度。
     *
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     *
     * 说明：叶子节点是指没有子节点的节点。
     *
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：2
     */

    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return help(root);
    }

    private int help(TreeNode root) {
        if(root.left == null && root.right == null) {
            return 1;
        }
        if(root.left == null) {
            return help(root.right) + 1;
        }
        if(root.right == null) {
            return help(root.left) + 1;
        }
        return Math.min(help(root.left), help(root.right)) + 1;
    }
}
