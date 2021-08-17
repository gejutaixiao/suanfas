package leetcode.suanfa.labuladong._3._3_2._3_2_1;

import leetcode.suanfa.leetcode.treenode.TreeNode;
import org.springframework.format.datetime.joda.MillisecondInstantPrinter;

import java.util.Deque;
import java.util.LinkedList;

public class MinDepth {

    //二叉树的最小深度

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                if (tmp.left == null && tmp.right == null) {
                    return depth;
                }
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
