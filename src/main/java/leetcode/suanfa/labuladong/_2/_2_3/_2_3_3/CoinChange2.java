package leetcode.suanfa.labuladong._2._2_3._2_3_3;

public class CoinChange2 {

    //零钱兑换Ⅱ
    /**
     * 有一个背包，最大容量为 amount，有一系列物品 coins，每个物品的重量为 coins[i]，每个物品的数量无限。
     * 请问有多少种方法，能够把背包恰好装满？
     */

    //1.暴力递归
    public static int coinChange1(int[] coins, int amount) {
        return dp(coins, amount, 0);
    }
    public static int dp(int[] coins, int rest, int index) {
        if(rest == 0) {
            return 1;
        }
        if(rest < 0 || index >= coins.length) {
            return 0;
        }
        int res = 0;
        if(rest - coins[index] < 0) {
            res = dp(coins, rest, index + 1);
        } else {
            res = dp(coins, rest - coins[index], index) + dp(coins, rest, index + 1);
        }
        return res;
    }

    //2.动态规划
    public static int coinChange2(int[] nums, int amount) {
        int n = nums.length;
        int[][] dp = new int[amount + 1][n + 1];
        for(int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }
        for(int i = 1; i <= amount; i++) {
            for(int j = 1; j <= n; j++) {
                if(i - nums[j - 1] < 0) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - nums[j - 1]][j];
                }
            }
        }
        return dp[amount][n];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5};
        System.out.println(coinChange2(nums, 5));
    }
}
