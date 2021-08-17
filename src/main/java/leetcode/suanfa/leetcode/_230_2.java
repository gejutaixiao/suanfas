package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _230_2 {

    //二叉搜索树中第k小的元素
    //https://leetcode-cn.com/tag/tree/problemset/

    /**
     * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
     */

    List<Integer> list;
    public int kthSmallest2(TreeNode root, int k) {
        list = new ArrayList<>();
        dfs(root);
        return list.get(k - 1);
    }
    public void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }


    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while(true) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(--k == 0) {
                return root.val;
            }
            root = root.right;
        }
    }
}
