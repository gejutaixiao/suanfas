package leetcode.suanfa.labuladong._2._2_5._2_5_11;

public class Rob1 {

    //打家劫舍1

    //1.暴力递归
    public static int rob1(int[] nums) {
        return dp(nums, 0);
    }
    public static int dp(int[] nums, int i) {
        if(i >= nums.length) {
            return 0;
        }
        return Math.max(nums[i] + dp(nums, i + 2), dp(nums, i + 1));
    }

    //2.动态规划
    public static int rob2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], dp[1]);
        for(int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n - 1];
    }

    //3.状态压缩
    public static int rob3(int[] nums) {
        int dp_0 = nums[0], dp_1 = Math.max(dp_0, nums[1]);
        for(int i = 2; i < nums.length; i++) {
            int max = Math.max(dp_0 + nums[i], dp_1);
            dp_0 = dp_1;
            dp_1 = max;
        }
        return dp_1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(rob1(nums));
        System.out.println(rob2(nums));
        System.out.println(rob3(nums));
    }
}
