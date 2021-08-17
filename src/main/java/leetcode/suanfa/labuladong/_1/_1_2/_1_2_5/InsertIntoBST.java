package leetcode.suanfa.labuladong._1._1_2._1_2_5;

import leetcode.suanfa.leetcode.treenode.TreeNode;

public class InsertIntoBST {

    /**
     * 在BST中插入一个数
     */
    public TreeNode insertIntoBST(TreeNode root, int target) {
        if(root == null) {
            return new TreeNode(target);
        }
        if(root.val < target) {
            root.right = insertIntoBST(root.right, target);
        }
        if(root.val > target) {
            root.left = insertIntoBST(root.left, target);
        }
        return root;
    }
}
