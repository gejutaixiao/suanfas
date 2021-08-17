package leetcode.suanfa.labuladong._1._1_2._1_2_5;

import leetcode.suanfa.leetcode.treenode.TreeNode;

public class IsValidBST {

    //判断BST的合法性
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if(root == null) {
            return true;
        }
        if(min != null && root.val <= min.val) {
            return false;
        }
        if(max != null && root.val >= max.val) {
            return false;
        }
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
}
