package leetcode.suanfa.labuladong._1._1_2._1_2_1;

import leetcode.suanfa.leetcode.listNode.ListNode;
import leetcode.suanfa.leetcode.treenode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {

    //翻转一颗二叉树

    //1.递归算法
    public TreeNode invertTree1(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        //反转root的左子树和右子树
        invertTree1(root.left);
        invertTree1(root.right);
        return root;
    }

    //2.BFS
    public TreeNode invertTree2(TreeNode root) {
        if(root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode cur = null;
        TreeNode temp = null;
        while(!queue.isEmpty()) {
            cur = queue.remove();
            if(cur != null) {
                temp = cur.left;
                cur.left = cur.right;
                cur.right = temp;
            }
            queue.add(root.left);
            queue.add(root.right);
        }
        return root;
    }
}
