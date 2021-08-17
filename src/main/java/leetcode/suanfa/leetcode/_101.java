package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.treenode.TreeNode;

public class _101 {

    //对称二叉树
    //https://leetcode-cn.com/tag/tree/problemset/
    //给定一个二叉树，检查它是否是镜像对称的。
    /**
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     */

    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return help(root.left, root.right);
    }

    private boolean help(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        if(left == null && right != null || left != null && right == null) {
            return false;
        }
        if(left != null && right != null && left.val != right.val) {
            return false;
        }
        return help(left.left, right.right) && help(left.right, right.left);
    }
}
