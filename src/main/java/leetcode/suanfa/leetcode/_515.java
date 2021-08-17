package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.treenode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _515 {

    //在每个树行中寻找最大值
    //https://leetcode-cn.com/tag/tree/problemset/

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            int maxNum = Integer.MIN_VALUE;
            for (int i = 0; i < length; i++) {
                TreeNode cur = queue.remove();
                maxNum = Math.max(maxNum, cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            res.add(maxNum);
        }
        return res;
    }
}
