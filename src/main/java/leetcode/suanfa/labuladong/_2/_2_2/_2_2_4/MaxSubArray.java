package leetcode.suanfa.labuladong._2._2_2._2_2_4;

public class MaxSubArray {

    //最大子序和
    /**
     * 给定一个整数数组，找到一个具有最大和的连续子数组，并返回其最大值
     */
    //1.动态规划
    public static int maxSubArray1(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        for(int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        int res = 0;
        for(int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    //2.状态压缩
    public static int maxSubArray2(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        int dp_0 = nums[0];
        int max = 0;
        for(int i = 1; i < n; i++) {
            dp_0 = Math.max(nums[i], dp_0 + nums[i]);
            max = Math.max(max, dp_0);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray2(nums));
    }
}
