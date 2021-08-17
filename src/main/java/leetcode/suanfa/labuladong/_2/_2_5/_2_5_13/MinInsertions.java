package leetcode.suanfa.labuladong._2._2_5._2_5_13;

import java.util.Arrays;

public class MinInsertions {

    //构造回文的最小插入次数
    /**
     * 输入一个字符串 s，你可以在字符串的任意位置插入任意字符。如果要把 s 变成回文串，请你计算最少要进行多少次插入？
     * 比如说输入 s = "abcea"，算法返回 2，因为可以给 s 插入 2 个字符变成回文串 "abeceba" 或者 "aebcbea"。
     * 如果输入 s = "aba"，则算法返回 0，因为 s 已经是回文串，不用插入任何字符。
     */

    //1.暴力递归
    public static int minInsertions1 (String s) {
        return dp(s, 0, s.length() - 1);
    }
    public static int dp(String s, int i, int j) {
        if(i >= j) {
            return 0;
        }
        if(s.charAt(i) == s.charAt(j)) {
            return dp(s, i + 1, j - 1);
        }
        return Math.min(dp(s, i + 1, j), dp(s, i, j - 1)) + 1;
    }

    //2.备忘录
    public static int minInsertions2(String s) {
        int[][] memo = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            Arrays.fill(memo[i], -1);
        }
        return dp(s, 0, s.length() - 1, memo);
    }
    public static int dp(String s, int i, int j, int[][] memo) {
        if(i >= j) {
            return 0;
        }
        if(memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = Integer.MAX_VALUE;
        if(s.charAt(i) == s.charAt(j)) {
            memo[i][j] = dp(s, i + 1, j - 1, memo);
            return memo[i][j];
        }
        res = Math.min(res, Math.min(dp(s, i + 1, j, memo), dp(s, i, j - 1, memo)) + 1);
        memo[i][j] = res;
        return res;
    }

    //3.动态规划
    public static int minInsertions3(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
//        for(int i = 0; i < n; i++) {
//            for(int j = i; j < n; j++) {
//                dp[i][j] = Integer.MAX_VALUE;
//            }
//        }
        //base case
//        for(int i = 0; i < n; i++) {
//            dp[i][i] = 1;
//        }
        for(int i = n - 2; i >= 0; i--) {
            for(int j = i + 1; j < n; j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][n - 1];
    }

    //4.状态压缩
    public static int minInsertions4(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int pre = 0;
        for(int i = n - 2; i >= 0; i--) {
            for(int j = i + 1; j < n; j++) {
                int temp = dp[j];
                if(s.charAt(i) == s.charAt(j)) {
                    dp[j] = pre;
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + 1;
                }
                pre = temp;
            }
        }
        return dp[n - 1];
    }




    public static void main(String[] args) {
        String s = "abceafadasdafsasf";
        System.out.println(minInsertions1(s));
        System.out.println(minInsertions2(s));
        System.out.println(minInsertions3(s));
        System.out.println(minInsertions4(s));
    }
}
