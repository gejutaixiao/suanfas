package leetcode.suanfa.gongshuisanye.BFS;

import leetcode.suanfa.labuladong._2._2_3._2_3_1.Knapsack;

import javax.lang.model.type.ReferenceType;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _403 {

    //青蛙过河
    // 1.BFS超时
    public static boolean canCross(int[] stones) {
        Queue<int[]> queue = new LinkedList<>();
        HashSet<Integer> vis = new HashSet<>();
        int target = stones[stones.length - 1];
        for (int stone : stones) {
            vis.add(stone);
        }
        if (!vis.contains(stones[0] + 1)) {
            return false;
        }
        queue.add(new int[]{stones[0] + 1, 1});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll[0] == target) {
                return true;
            }
            for (int j = -1; j <= 1; j++) {
                int k = poll[1] + j;
                if (k == 0) {
                    continue;
                }
                if (Integer.MAX_VALUE - poll[0] < k) {
                    continue;
                }
                int next = poll[0] + k;
                if (vis.contains(next)) {
                    queue.add(new int[]{next, k});
                }
            }
        }
        return false;
    }

    // 2.动态规划
    public static boolean canCross2(int[] stones) {
        int n = stones.length;
        if (stones[1] != 1) {
            return false;
        }
        boolean[][] dp = new boolean[n + 1][n + 1];
        dp[1][1] = true;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                int k = stones[i] - stones[j];
                if (k <= j + 1) {
                    dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (dp[n][i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] stones = {0,1,3,5,6,8,12,17};
        System.out.println(canCross(stones));
    }
}
