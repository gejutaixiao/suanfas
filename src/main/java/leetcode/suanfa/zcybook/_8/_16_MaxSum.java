package leetcode.suanfa.zcybook._8;

import java.util.Random;

public class _16_MaxSum {

    //子数组的最大累加和问题

    public static int maxSum(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
        }
        return dp[n - 1];
    }

    public static int maxSum1(int[] arr) {
        int n = arr.length;
        int dp_pre = arr[0];
        int dp_res = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            dp_res = Math.max(dp_pre + arr[i], arr[i]);
            dp_pre = dp_res;
        }
        return dp_res;
    }

    public static void main(String[] args) {
        int[] arr = new int[300];
        Random random = new Random();
        long l = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            for (int j = 0; j < 300; j++) {
                arr[j] = random.nextInt(213) * (random.nextInt(2) >= 1 ? 1 : -1);
            }
            if (maxSum(arr) != maxSum1(arr)) {
                System.err.println("出现问题！！！");
            }
        }
        System.out.println("prefect!!!");
        System.out.println(System.currentTimeMillis() - l + "ms");
    }
}
