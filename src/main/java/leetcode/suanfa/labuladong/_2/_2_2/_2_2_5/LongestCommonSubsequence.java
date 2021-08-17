package leetcode.suanfa.labuladong._2._2_2._2_2_5;

public class LongestCommonSubsequence {

    //最长公共子序列
    /**
     * 给你输入两个字符串s1和s2，请你找出他们俩的最长公共子序列，返回这个子序列的长度。
     */

    //1.暴力递归
    public static int longestCommonSubsequence1(String s1, String s2) {
        return dp(s1, 0, s2, 0);
    }

    public static int dp(String s1, int index1, String s2, int index2) {
        //base case
        if(index1 == s1.length() || index2 == s2.length()) {
            return 0;
        }
        if(s1.charAt(index1) == s2.charAt(index2)) {
            return 1 + dp(s1, index1 + 1, s2, index2 + 1);
        }
        return Math.max(dp(s1, index1 + 1, s2, index2), dp(s1, index1, s2, index2 + 1));
    }


    //2.动态规划
    public static int longestCommonSubsequence2(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s1 = "zabcde";
        String s2 = "acez";
        System.out.println(longestCommonSubsequence2(s1, s2));
    }
}
