package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.treenode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _513 {

    //找树左下角的值
    //https://leetcode-cn.com/tag/tree/problemset/

    /**
     * 给定一个二叉树，在树的最后一行找到最左边的值。
     */

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode leftNode = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (i == 0) {
                    leftNode = node;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return leftNode == null ? 0 : leftNode.val;
    }
}
