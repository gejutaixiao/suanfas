package leetcode.suanfa.labuladong._2._2_5._2_5_4;

import java.util.Random;

public class IsMatch {

    //正则表达式匹配
    public static boolean isMatch(String s, String p) {
        return dp(s, 0, p, 0);
    }
    public static boolean dp(String s, int i, String p, int j) {
        if (j == p.length()) {
            return i == s.length();
        }
        boolean first_match = s.charAt(i) == p.charAt(j);
        return first_match && dp(s, i + 1, p, j + 1);
    }

    public static boolean isMatch2(String s, String p) {
        return dp2(s, 0, p, 0);
    }
    public static boolean dp2(String s, int i , String p, int j) {
        if (j == p.length()) {
            return i == s.length();
        }
        boolean first_match = s.charAt(i) == p.charAt(j) || p.charAt(j) == '.';
        return first_match && dp2(s, i + 1, p, j + 1);
    }

    public static boolean isMatch3(String s, String p) {
        return dp3(s, 0, p, 0);
    }
    public static boolean dp3(String s, int i, String p, int j) {
        if (p.length() == j) {
            return s.length() == i;
        }
        boolean first_match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
            return dp3(s, i, p, j + 2) || first_match && dp3(s, i + 1, p, j);
        } else {
            return first_match && dp3(s, i + 1, p, j + 1);
        }
    }

    public static boolean isMatch4(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                boolean first_match = s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.';
                if (p.charAt(j - 1) == '*') {
                    if (j >= 2) {
                        dp[i][j] = dp[i][j - 2] || first_match && dp[i - 1][j];
                    } else {
                        dp[i][j] = first_match && dp[i - 1][j];
                    }
                } else {
                    dp[i][j] = first_match && dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        char[] ch1 = {'a', 'b', 'c', 'd', 'e', 'f'};
        char[] ch2 = {'.', '*'};
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            String s1 = ch1[0] + "";
            String s2 = ch1[random.nextInt(ch1.length)] + "";
            for (int k = 0; k < 10; k++) {
                s1 += ch1[random.nextInt(ch1.length)];
                if (k % 2 == 0) {
                    s2 += ch1[random.nextInt(ch1.length)];
                } else {
                    s2 += ch2[random.nextInt(ch2.length)];
                }
            }
            System.out.println(s1 + ": " + s2);
            if (isMatch3(s1, s2) != isMatch4(s1, s2)) {
                System.err.println("出现错误");
            }
        }
        System.out.println("毫无问题");
    }
}
