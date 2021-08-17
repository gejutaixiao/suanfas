package leetcode.suanfa.labuladong._2._2_1._2_1_1;

import java.util.Arrays;

public class CoinChange {

    //凑零钱问题
    /**
     * 给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，每种硬币的数量无限，再给一个总金额 amount，
     * 问你最少需要几枚硬币凑出这个金额，如果不可能凑出，算法返回 -1 。
     */

    public static int coinChange(int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }
        if(amount < 0) {
            return -1;
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++) {
            int num = coinChange(coins, amount - coins[i]);
            //子问题无解跳过
            if(num == -1) {
                continue;
            }
            res = Math.min(res, num + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        //外层循环遍历amount的所有取值
        for(int i = 1; i <= amount; i++) {
            //内层循环遍历硬币金额
            for(int coin : coins) {
                if(i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(coinChange2(coins, 11));
    }
}
