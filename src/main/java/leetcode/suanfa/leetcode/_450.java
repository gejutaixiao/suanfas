package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.treenode.TreeNode;

public class _450 {

    //删除二叉搜索树中的节点
    //https://leetcode-cn.com/tag/tree/problemset/

    /**
     * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。
     * 返回二叉搜索树（有可能被更新）的根节点的引用。
     *
     * 一般来说，删除节点可分为两个步骤：
     *
     * 首先找到需要删除的节点；
     * 如果找到了，删除它。
     * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
     *
     */

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }
        if(root.val == key) {
            if(root.left == null) {
                return root.right;
            }
            if(root.right == null) {
                return root.left;
            }
            int minNode = getMin(root.right);
            root.val = minNode;
            root.right = deleteNode(root.right, minNode);
        } else if(root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left,key);
        }
        return root;
    }
    public int getMin(TreeNode root) {
        while(root.left != null) {
            root = root.left;
        }
        return root.val;
    }
}
