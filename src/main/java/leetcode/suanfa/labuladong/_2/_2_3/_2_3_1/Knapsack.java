package leetcode.suanfa.labuladong._2._2_3._2_3_1;

public class Knapsack {

    //0-1背包问题

    //1.暴力递归
    public static int knapsack(int W, int N, int[] weights, int[] val) {
        return dp(W, 0, weights, val);
    }
    public static int dp(int rest, int index, int[] weights, int[] val) {
        //base case
        if(rest < 0) {
            return -1;
        }
        if(rest == 0 || index >= weights.length) {
            return 0;
        }
        int res = 0;
        if(dp(rest - weights[index], index + 1, weights, val) != -1) {
            res = Math.max(dp(rest, index + 1, weights, val), dp(rest - weights[index], index + 1, weights, val) + val[index]);
        } else {
            res = dp(rest, index + 1, weights, val);
        }
        return res;
    }

    //2.动态规划
    public static int knapsack2(int W, int N, int[] weights, int[] val) {
        //dp[W][N]表示背包容量为W的前提下，将前N个物品放入背包所能得到的最大价值
        int[][] dp = new int[W + 1][N + 1];
        for(int i = 1; i <= W; i++) {
            for(int j = 1; j <= N; j++) {
                if(i - weights[j - 1] < 0) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - weights[j - 1]][j - 1] + val[j - 1], dp[i][j - 1]);
                }
            }
        }
        return dp[W][N];
    }

    public static void main(String[] args) {
        int[] weights = {2, 1, 3, 1};
        int[] val = {4, 2, 3, 4};
        System.out.println(knapsack2(4, 4, weights, val));
    }
}
