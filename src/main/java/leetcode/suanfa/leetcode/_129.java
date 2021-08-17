package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.treenode.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _129 {

    //求根节点到叶节点数字之和

    /**
     * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
     * 每条从根节点到叶节点的路径都代表一个数字：
     *
     * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
     * 计算从根节点到叶节点生成的 所有数字之和 。
     *
     * 叶节点 是指没有子节点的节点。
     *
     */
    int res = 0;
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }
        dfs(root);
        return res;
    }
    public void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        sum = sum * 10 + root.val;
        if(root.left == null && root.right == null) {
            res += sum;
        }
        dfs(root.left);
        dfs(root.right);
        sum = (sum - root.val) / 10;
    }
}
class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }
}

