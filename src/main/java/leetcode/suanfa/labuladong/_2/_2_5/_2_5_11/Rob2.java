package leetcode.suanfa.labuladong._2._2_5._2_5_11;

public class Rob2 {

    //打家劫舍Ⅱ

    //1.暴力递归
    public static int rob1(int[] nums) {
        return Math.max(dp(nums, 0, nums.length - 2), dp(nums, 1, nums.length - 1));
    }
    public static int dp(int[] nums, int i, int j) {
        if(i > j) {
            return 0;
        }
        return Math.max(nums[i] + dp(nums, i + 2, j), dp(nums, i + 1, j));
    }

    //2.动态规划
    public static int rob2(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        return Math.max(dp2(nums, 0, n - 2), dp2(nums, 1, n - 1));
    }
    public static int dp2(int[] nums, int i, int j) {
        int dp_0 = nums[i], dp_1 = nums[i + 1], dp_sum = 0;
        for(int k = i + 2; k <= j; k++) {
            dp_sum = Math.max(dp_0 + nums[k], dp_1);
            dp_0 = dp_1;
            dp_1 = dp_sum;
        }
        return dp_1;
    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 2, 4, 5, 12, 5, 2};
        System.out.println(rob1(nums));
        System.out.println(rob2(nums));
    }
}
