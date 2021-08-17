package leetcode.suanfa.labuladong._2._2_2._2_2_6;

public class LongestPalindromeSubseq {

    //最长回文子序列
    /**
     * 给定一个字符串s，找到其中最长的回文子序列，可以假设s的最大长度为1000
     */


    //1.暴力递归
    public static int longestPalindromeSubseq1(String s) {
        return dp(s, 0, s.length() - 1);
    }
    public static int dp(String s, int left, int right) {
        //base case
        if (left < 0 || right >= s.length() || left > right) {
            return 0;
        }
        if(left == right) {
            return 1;
        }

        //进行判断
        if(s.charAt(left) == s.charAt(right)) {
            return 2 + dp(s, left + 1, right - 1);
        }
        return Math.max(dp(s, left + 1, right), dp(s, left, right - 1));
    }

    //2.动态规划
    public static int longestPalindromeSubseq2(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        //dp[0][n - 1]表示字符串s的最长回文子序列长度
        for(int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i + 1; j < n; j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }


    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(longestPalindromeSubseq2(s));
    }
}
