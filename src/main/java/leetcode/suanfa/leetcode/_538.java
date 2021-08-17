package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.treenode.TreeNode;

public class _538 {

    //把二叉树转换成累加树
    //给出二叉搜索树的根节点，该树的节点值各不相同，请你将其转换成累加树
    //使每个节点node的新值等于原树中大于或等于node.val的值之和

    public int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    public void traverse(TreeNode root) {
        if(root == null) return;
        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
    }
}
