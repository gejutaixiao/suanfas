package leetcode.suanfa.leetcode;

public class _Offer19 {

    //正则表达式匹配

    //递归
    public static boolean isMatch(String s, String p) {
        return dfs(s, 0, p, 0);
    }
    public static boolean dfs(String s, int i, String p, int j) {
        if (j == p.length()) {
            return i == s.length();
        }
        boolean first_match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
            return dfs(s, i, p, j + 2) || first_match && dfs(s, i + 1, p, j);
        }
        return first_match && dfs(s, i + 1, p, j + 1);
    }

    //动态规划
    public static boolean isMatch2(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                boolean first_match = s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.';
                if (j >= 2) {
                    if (p.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i][j - 2] || first_match && dp[i - 1][j];
                    } else {
                        dp[i][j] = first_match && dp[i - 1][j - 1];
                    }
                } else {
                    dp[i][j] = first_match && dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aab", "c*a*b"));
    }
}
