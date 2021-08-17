package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.treenode.TreeNode;

import java.util.LinkedList;

public class _653 {

    //两数之和 IV - 输入 BST
    /**
     * 给定一个二叉搜索树和一个目标结果，
     * 如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
     */

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        LinkedList<Integer> list = new LinkedList<>();
        dfs(root, list);
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int sum = list.get(left) + list.get(right);
            if (sum == k) {
                return true;
            } else if (sum > k) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }

    private void dfs(TreeNode root, LinkedList<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
}
