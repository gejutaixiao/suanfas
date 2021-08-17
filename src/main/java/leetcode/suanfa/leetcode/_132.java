package leetcode.suanfa.leetcode;

public class _132 {

    //分割回文串
    /**
     * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
     *
     * 返回符合要求的 最少分割次数 。
     */

    public static int minCut(String s) {
        if (s.length() < 2) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        boolean[][] p = new boolean[n][n];
        dp[n] = -1;
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || p[i + 1][j - 1])) {
                    dp[i] = Math.min(dp[j + 1] + 1, dp[i]);
                    p[i][j] = true;
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(minCut("abb"));
    }
}
