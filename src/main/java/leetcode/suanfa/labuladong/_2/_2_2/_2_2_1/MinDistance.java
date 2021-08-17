package leetcode.suanfa.labuladong._2._2_2._2_2_1;

import org.apache.logging.log4j.util.Strings;

public class MinDistance {

    //编辑距离
    /**
     * 给定两个字符串s1，s2，计算出将s1转换成s2所使用的最少操作数
     */

    //1.暴力递归
    public static int minDistance1(String s1, String s2) {
        return dp(s1, s1.length() - 1, s2, s2.length() - 1);
    }
    public static int dp(String s1, int index1, String s2, int index2) {
        if(index1 < 0) {
            return index2 + 1;
        }
        if(index2 < 0) {
            return index1 + 1;
        }
        if(s1.charAt(index1) == s2.charAt(index2)) {
            return dp(s1, index1 - 1, s2, index2 - 1);
        }
        return Math.min(dp(s1, index1 - 1, s2, index2), Math.min(dp(s1, index1, s2, index2 - 1), dp(s1, index1 - 1, s2, index2 - 1))) + 1;
    }

    //2.动态规划
    public static int minDistance2(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for(int j = 0; j < n + 1; j++) {
            dp[0][j] = j;
        }
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s1 = "intention";
        String s2 = "execution";
        System.out.println(minDistance2(s1, s2));
    }
}
