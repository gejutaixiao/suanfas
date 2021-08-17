package leetcode.suanfa.labuladong._2._2_5._2_5_7;

import java.util.ArrayList;
import java.util.Random;


/**
 * 出现一个数组的问题，有以下几种方法：
 *      1. 以i为结尾的dp数组： 返回结果一般是遍历dp数组找到最大值
 *      2. 以一端index为推进的dp数组： 返回结果一般是dp[n - 1]，base case一般是dp[0]=?
 *      3. 以数组两端点为推进的dp数组： 返回结果一般是dp[0][n - 1]，base case一般是dp[i][i]=?
 *      上述方法在一个字符串上也同样适用。
 *
 *  两个字符串的问题，一般是双指针，两个字符串各有一个指针，同时指向起点或终点。
 */
public class ChuoQiQiu {

    //戳气球

    public static int stick(int[] nums) {
        int[] points = new int[nums.length + 2];
        points[0] = 1;
        points[points.length - 1] = 1;
        for (int i = 1; i < points.length - 1; i++) {
            points[i] = nums[i - 1];
        }
        return dp(points, 0, points.length - 1);
    }

    //戳气球所在的区间为（i， j）不包含i，j
   public static int dp(int[] points, int i, int j) {
        if (i >= j) {
            return 0;
        }
        //k表示（i，j）中第k个气球首先被戳
        int res = 0;
        for (int k = i + 1; k < j; k++) {
            res = Math.max(res, dp(points, i, k) + dp(points, k, j) + points[k] * points[i] * points[j]);
        }
        return res;
   }

   public static int maxCoins(int[] nums) {
        int[] points = new int[nums.length + 2];
        int n = points.length;
        points[0] = points[n - 1] = 1;
        for (int i = 1; i < n - 1; i++) {
            points[i] = nums[i - 1];
        }
        int[][] dp = new int[n][n];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j ++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][k] + dp[k][j] + points[i] * points[k] * points[j], dp[i][j]);
                }
            }
        }
        return dp[0][n - 1];
   }


    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            int[] nums = new int[10];
            for (int k = 0; k < 10; k++) {
                nums[k] = random.nextInt(50);
            }
            if (stick(nums) != maxCoins(nums)) {
                System.err.println("出现错误！！！");
            }
        }
        System.out.println("毫无问题！！！");
    }
}
