package 面试;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class pdd3 {

    public static int pro3(int[] arr) {
        int A = arr[0];
        int B = arr[1];
        int C = arr[2];
        int Q = arr[3];
        boolean[] dp = new boolean[Q + 1];
        dp[A] = true;
        for (int i = A + 1; i <= Q; i++) {
            if (i - B >= 0) {
                dp[i] = dp[i - B];
            }
            if (!dp[i] && i % C == 0) {
                dp[i] = dp[i] || (dp[i / C] && i % C == 0);
            }
        }
        return dp[Q] == true ? 1 : 0;
    }

    public static int pro3_1(int[] arr) {
        int A = arr[0];
        int B = arr[1];
        int C = arr[2];
        int Q = arr[3];
        int n = Q / B + 2;
        int[] dp = new int[Q];
        dp[1] = A;
        int max = A;
        int p1 = 1, p2 = 1;
        for (int i = 2; i < Q; i++) {
            int dp1 = dp[p1] + B, dp2 = dp[p2] * C;
            dp[i] = Math.min(dp1, dp2);
            if (dp[i] == Q) {
                return 1;
            }
            if (dp[i] > Q) {
                return 0;
            }
            if (dp[i] == dp1) {
                p1++;
            } else {
                p2++;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] arr = new int[4];
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            int pre = 1;
            for (int j = 0; j < 4; j++) {
                arr[j] = random.nextInt(j * 1000000 + 100) + pre;
                pre += arr[j];
            }
            if (pro3(arr) != pro3_1(arr)) {
                System.err.println("y89");
            }
        }
        System.out.println("prefect!");
    }
}
