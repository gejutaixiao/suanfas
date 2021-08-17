package leetcode.suanfa.labuladong._2._2_2._2_2_5;

public class MinDistance {

    //两个字符串的删除操作
    /**
     * 题目让我们计算将两个字符串变得相同的最少删除次数，那我们可以思考一下，最后这两个字符串会被删成什么样子？
     */

    //1.暴力递归
    public static int minDistance(String s1, String s2) {
        return dp(s1, 0, s2, 0);
    }

    public static int dp(String s1, int index1, String s2, int index2) {
        if(index1 == s1.length()) {
            return s2.length() - index2;
        }
        if(index2 == s2.length()) {
            return s1.length() - index1;
        }
        if(s1.charAt(index1) == s2.charAt(index2)) {
            return dp(s1, index1 + 1, s2, index2 + 1);
        }
        return Math.min(dp(s1, index1 + 1, s2, index2), dp(s1, index1, s2, index2 + 1)) + 1;
    }

    //2.动态规划
    public static int minDistance2(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for(int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }



    public static void main(String[] args) {
        String s1 = "esfaatat";
        String s2 = "easfasgasa";
        System.out.println(minDistance2(s1, s2));
    }
}
