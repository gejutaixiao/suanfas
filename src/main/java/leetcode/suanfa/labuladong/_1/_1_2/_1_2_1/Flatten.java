package leetcode.suanfa.labuladong._1._1_2._1_2_1;

import leetcode.suanfa.leetcode.treenode.TreeNode;

public class Flatten {

    //二叉树展开为链表
    //给你二叉树的根节点root，请你将它展开为一个单链表
    //展开后的单链表应该与二叉树的先序遍历顺序相同

    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);

        //后序遍历位置
        //1.左右子树已经被拉成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        //2.将左子树接到root的右子树上
        root.right = left;
        root.left = null;

        //3.将原先的右子树接到当前的右子树上
        TreeNode p = root;
        while(p.right != null) {
            p = p.right;
        }
        p.right = right;
    }
}
