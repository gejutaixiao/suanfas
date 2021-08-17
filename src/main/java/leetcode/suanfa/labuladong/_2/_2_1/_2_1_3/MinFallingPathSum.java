package leetcode.suanfa.labuladong._2._2_1._2_1_3;

import java.util.Arrays;

public class MinFallingPathSum {

    //下降路径最小和
    /**
     * 输入为一个 n * n 的二维数组 matrix，请你计算从第一行落到最后一行，经过的路径和最小为多少。
     */

    //1.暴力递归
    public static int minFallingPathSum1(int[][] matrix) {
        int n = matrix.length;
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++) {
            min = Math.min(min, dp(matrix, n - 1, j));
        }
        return min;
    }
    public static int dp(int[][] matrix, int i, int j) {
        int n = matrix.length;
        if(i < 0 || i >= n || j < 0 || j >= n) {
            return Integer.MAX_VALUE;
        }
        //base case
        if(i == 0) {
            return matrix[i][j];
        }
        return matrix[i][j] + Math.min(Math.min(dp(matrix, i - 1, j), dp(matrix, i - 1, j + 1)), dp(matrix, i - 1, j - 1));
    }

    public static void main(String[] args) {
        int[][] matrix = {{2, 1, 3, 5}, {6, 5, 4, 7}, {7, 8, 9, 4}, {9, 5, 5, 7}};

        System.out.println(minFallingPathSum1(matrix));
        System.out.println(minFallingPathSum2(matrix));
        System.out.println(minFallingPathSum3(matrix));
        System.out.println(minFallingPathSum4(matrix));
    }

    //2.利用备忘录
    public static int minFallingPathSum2(int[][] matrix) {
        int n = matrix.length;
        int[][] memo = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(memo[i], 77777);
        }
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++) {
            min = Math.min(min, dp2(matrix, n - 1, j, memo));
        }
        return min;
    }
    public static int dp2(int[][] matrix, int i, int j, int[][] memo) {
        int n = matrix.length;
        if(i < 0 || i >= n || j < 0 || j >= n) {
            return Integer.MAX_VALUE;
        }
        //base case
        if(i == 0) {
            return matrix[i][j];
        }
        if(memo[i][j] != 77777) {
            return memo[i][j];
        }
        memo[i][j] = matrix[i][j] + Math.min(Math.min(dp2(matrix, i - 1, j, memo), dp2(matrix, i - 1, j + 1, memo)), dp2(matrix, i - 1, j - 1, memo));
        return memo[i][j];
    }

    //3.动态规划
    public static int minFallingPathSum3(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for(int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + matrix[i][j];
                } else if(j == n - 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + matrix[i][j];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i - 1][j + 1]) + matrix[i][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++) {
            min = Math.min(min, dp[n - 1][j]);
        }
        return min;
    }

    //4.压缩路径
    public static int minFallingPathSum4(int[][] matrix) {
        int n = matrix.length;
        int[] dp = new int[n];
        for(int j = 0; j < n; j++) {
            dp[j] = matrix[0][j];
        }
        int pre = 0;
        int cur = 0;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < n; j++) {
                cur = dp[j];
                if(j == 0) {
                    dp[j] = Math.min(dp[j], dp[j + 1]) + matrix[i][j];
                } else if(j == n - 1) {
                    dp[j] = Math.min(dp[j], pre) + matrix[i][j];
                } else {

                    dp[j] = Math.min(Math.min(dp[j], pre), dp[j + 1]) + matrix[i][j];
                }
                pre = cur;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            min = Math.min(dp[i], min);
        }
        return min;
    }
}
