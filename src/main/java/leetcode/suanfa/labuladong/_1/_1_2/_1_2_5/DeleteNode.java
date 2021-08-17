package leetcode.suanfa.labuladong._1._1_2._1_2_5;

import leetcode.suanfa.leetcode.treenode.TreeNode;

public class DeleteNode {

    /**
     * 在BST中删除某一结点
     */
    public TreeNode deleteNode(TreeNode root, int target) {
        if(root == null) {
            return null;
        }
        if(root.val == target) {
            //这两个if把情况1，2都处理了
            if(root.left == null) {
                return root.right;
            }
            if(root.right == null) {
                return root.left;
            }
            //处理情况3
            TreeNode minNode = getMinNode(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        } else if(root.val < target) {
            root.right = deleteNode(root.right, target);
        } else if(root.val > target) {
            root.left = deleteNode(root.left, target);
        }
        return root;
    }
    public TreeNode getMinNode(TreeNode root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }
}
