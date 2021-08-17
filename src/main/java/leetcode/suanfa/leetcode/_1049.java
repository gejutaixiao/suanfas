package leetcode.suanfa.leetcode;

import java.util.PriorityQueue;

public class _1049 {

    //最后一块石头的重量Ⅱ
    public static int lastStone(int[] stones) {
        if (stones.length == 0) {
            return stones[0];
        }
        int sum = 0;
        int n = stones.length;
        for (int stone : stones) {
            sum += stone;
        }
        int[][] dp = new int[n + 1][sum / 2 + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum / 2; j++) {
                if (j - stones[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j - stones[i - 1]] + stones[i - 1], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return sum - dp[n][sum / 2] * 2;
    }

    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        int[] stones2 = {31, 26, 33, 21, 40};
        System.out.println(lastStone(stones));
    }


    /**
     * 2, 7, 4, 1, 8, 1
     * 2, 6, 4, 7
     * 3, 4
     */
}
