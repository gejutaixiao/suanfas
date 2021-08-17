package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.treenode.TreeNode;

public class _230 {

    //二叉搜索树中第k小的元素
    public int index = 0;
    public int res = 0;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    public void traverse(TreeNode root, int k) {
        if(root == null) return;
        traverse(root.left, k);
        index++;
        if(index == k) {
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }
}
