package leetcode.suanfa.leetcode;

public class _312 {

    //戳气球

    //1.暴力递归
    public static int maxCoins1(int[] nums) {
        int n = nums.length;
        int[] points = new int[n + 2];
        points[0] = points[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            points[i + 1] = nums[i];
        }
        return dp(points, 0, n + 1);
    }
    public static int dp(int[] points, int i, int j) {
        if (i >= j) {
            return 0;
        }
        //最后再戳位于区间（i，j）的第k个气球
        int res = 0;
        for (int k = i + 1; k < j; k++) {
            res = Math.max(res, dp(points, i, k) + dp(points, k, j) + points[k] * points[i] * points[j]);
        }
        return res;
    }

    //2.动态规划
    public static int maxCoins2(int[] nums) {
        int n = nums.length + 2;
        int[] points = new int[n];
        points[0] = points[n - 1] = 1;
        for (int i = 1; i < n - 1; i++) {
            points[i] = nums[i - 1];
        }
        int[][] dp = new int[n][n];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + points[k] * points[i] * points[j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
