package leetcode.suanfa.labuladong._2._2_2._2_2_5;

public class MinimumDeleteSum {

    //两个字符串的最小ASCII删除和
    /**
     * 给定两个字符串s1，s2，找到使两个字符串相等所需删除字符的ASCII最小删除和
     */


    //1.暴力递归
    public static int minimumDeleteSum(String s1, String s2) {
        return dp(s1, 0, s2, 0);
    }
    public static int dp(String s1, int index1, String s2, int index2) {
        int res = 0;
        if(index1 == s1.length()) {
            for(; index2 < s2.length(); index2++) {
                res += s2.charAt(index2);
            }
            return res;
        }
        if(index2 == s2.length()) {
            for(; index1 < s1.length(); index1++) {
                res += s1.charAt(index1);
            }
            return res;
        }
        if(s1.charAt(index1) == s2.charAt(index2)) {
            res = dp(s1, index1 + 1, s2, index2 + 1);
        } else {
            res = Math.min(s1.charAt(index1) + dp(s1, index1 + 1, s2, index2), s2.charAt(index2) + dp(s1, index1, s2, index2 + 1));
        }
        return res;
    }


    //2.动态规划
    public static int minimumDeleteSum2(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }
        for(int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        }
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s1 = "eat";
        String s2 = "sea";
        System.out.println(minimumDeleteSum2(s1, s2));
    }
}
