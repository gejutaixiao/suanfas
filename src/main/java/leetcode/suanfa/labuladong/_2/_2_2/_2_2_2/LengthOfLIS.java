package leetcode.suanfa.labuladong._2._2_2._2_2_2;

import java.util.Arrays;

public class LengthOfLIS {

    //最长递增子序列
    /**
     * 给定一个无序整数数组，找出其中最长上升子序列的长度
     */

    public static int lengthOfLIS(int[] nums) {
        //dp[i]表示以nums[i]结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }
}
