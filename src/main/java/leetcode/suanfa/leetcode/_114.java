package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.treenode.TreeNode;

public class _114 {

    //二叉树展开为链表
    //https://leetcode-cn.com/tag/tree/problemset/
    //给你二叉树的根结点root，请你将它展开为一个单链表
    //展开后的单链表应该同样使用TreeNode，其中right子指针指向链表中下一个结点，而左子指针始终为null
    //展开后的单链表应该与二叉树先序遍历顺序相同

    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        //将root的左子树展开为链表
        flatten(root.left);
        //将root的右子树展开为链表
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        //将root的左子树连接到root的右子树上
        root.right = left;
        root.left = null;
        TreeNode cur = root;
        while(cur.right != null) {
            cur = cur.right;
        }
        cur.right = right;
    }
}
