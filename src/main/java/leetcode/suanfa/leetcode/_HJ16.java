package leetcode.suanfa.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class _HJ16 {

    public static int dp(List<String[]> list, int money) {
        int n = list.size();
        int[][] dp = new int[n + 1][money + 1];

        for (int i = 1; i <= n; i++) {
            HashSet<Integer> set = new HashSet<>();
            String[] s = list.get(i - 1);
            int v = Integer.parseInt(s[0]);
            int w = Integer.parseInt(s[1]);
            int q = Integer.parseInt(s[2]);
            for (int j = 1; j <= money; j++) {
                if (j < v) {  //钱不够
                    dp[i][j] = dp[i - 1][j];
                } else {  //钱够
                    if (q != 0 && !set.contains(q)) {  //该商品是附件且没有购买主件
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v] + v * w);
                        if (dp[i][j] != dp[i - 1][j]) {
                            set.add(i);
                        }
                    }
                }
            }
        }
        return dp[n][money];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int money = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);
        List<String[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLine().split(" "));
        }
        System.out.println(dp(list, money));
    }
}
