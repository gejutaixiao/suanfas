package leetcode.suanfa.labuladong._1._1_2._1_2_6;

public class NumTrees {

    //不同的二叉搜索树
    /**
     * 给你输入一个正整数 n，请你计算，存储 {1,2,3...,n} 这些值共有有多少种不同的 BST 结构。
     */
    int[][] memo;
    public int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        return count(1, n);
    }

    private int count(int start, int end) {
        if(start > end) {
            return 1;
        }
        if(memo[start][end] != 0) {
            return memo[start][end];
        }
        int res = 0;
        for(int i = start; i <= end; i++) {
           int left = count(start, i - 1);
           int right = count(i + 1, end);
           res += left * right;
        }
        memo[start][end] = res;
        return res;
    }
}
