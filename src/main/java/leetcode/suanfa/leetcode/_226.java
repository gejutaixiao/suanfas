package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.treenode.TreeNode;

public class _226 {

    //翻转一棵二叉树
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        //递归反转root的左子树和右子树
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
