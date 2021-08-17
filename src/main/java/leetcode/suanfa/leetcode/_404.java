package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.treenode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _404 {

    //左叶子之和
    //计算给定二叉树的所有左叶子之和。
    //https://leetcode-cn.com/tag/tree/problemset/

    public int sumOfLeftLeaves(TreeNode root) {
        return root == null ? 0 : dfs(root);
    }
    public int dfs(TreeNode root) {
        int ans = 0;
        if(root.left != null) {
            ans += isLeftLeave(root.left) ? root.left.val : dfs(root.left);
        }
        if(root.right != null && !isLeftLeave(root.right)) {
            ans += dfs(root.right);
        }
        return ans;
    }
    public boolean isLeftLeave(TreeNode root) {
        return root.left == null && root.right == null;
    }

    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (isLeafNode(node.left)) {
                    ans += node.left.val;
                } else {
                    queue.offer(node.left);
                }
            }
            if (node.right != null) {
                if (!isLeafNode(node.right)) {
                    queue.offer(node.right);
                }
            }
        }
        return ans;
    }

    public boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

}
