package leetcode.suanfa.leetcode;

import java.util.Arrays;

public class _96 {

    //不同的二叉搜索树
    //https://leetcode-cn.com/tag/tree/problemset/
    /**
     * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
     */
    int[][] memo;

    public int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        return count(1, n);
    }

    public int count(int start, int end) {
        if (start > end) {
            return 1;
        }
        if (memo[start][end] != 0) {
            return memo[start][end];
        }
        int res = 0;
        for (int i = start; i <= end; i++) {
            int left = count(start, i - 1);
            int right = count(i + 1, end);
            res += left * right;
        }
        memo[start][end] = res;
        return res;
    }
}
