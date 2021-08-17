package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.treenode.TreeNode;

import java.util.*;

public class _113 {

    //路经总和
    //https://leetcode-cn.com/tag/tree/problemset/

    /**
     * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
     *
     * 叶子节点 是指没有子节点的节点。
     *
     */

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> list = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }
    public void dfs(TreeNode root, int targetSum) {
        if(root == null) {
            return;
        }
        list.addLast(root.val);
        targetSum -= root.val;
        if(root.left == null && root.right == null && targetSum == 0) {
            res.add(new LinkedList<>(list));
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        list.pollLast();
    }
}
