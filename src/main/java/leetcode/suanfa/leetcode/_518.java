package leetcode.suanfa.leetcode;

import java.util.Random;

public class _518 {

    //零钱兑换Ⅱ

    /**
     * 有一个背包，最大容量为 amount，有一系列物品 coins，每个物品的重量为 coins[i]，每个物品的数量无限。请问有多少种方法，能够把背包恰好装满？
     * @param amount
     * @param coins
     * @return
     */
    public static int change1(int amount, int[] coins) {
        return dp(amount, coins, 0);
    }
    public static int dp(int rest, int[] coins, int i) {
        if (rest == 0) {
            return 1;
        }
        if (rest < 0 || i >= coins.length) {
            return 0;
        }
        if (rest - coins[i] >= 0) {
            return dp(rest, coins, i + 1) + dp(rest - coins[i], coins, i);
        }
        return dp(rest, coins, i + 1);
    }

    public static int change2(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 3, 4, 5};
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            int amount = random.nextInt(100);
            if (change1(amount, coins) != change2(amount, coins)) {
                System.err.println("出现错误！！！");
            }
        }
        System.out.println("毫无问题！！！");
    }
}
