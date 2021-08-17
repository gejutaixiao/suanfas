package leetcode.suanfa.labuladong._2._2_3._2_3_2;

public class CanPartition {

    //分割等和子集
    /**
     * 给一个可装载重量为 sum / 2 的背包和 N 个物品，每个物品的重量为 nums[i]。
     * 现在让你装物品，是否存在一种装法，能够恰好将背包装满？
     */

    //1.暴力递归
    public static boolean canPartition (int[] nums) {
        int sum = getSums(nums);
        if(sum % 2 == 1) {
            return false;
        }
        return dp(nums, sum / 2, 0);
    }

    public static int getSums(int[] nums) {
        int sum = 0;
        for(int n : nums) {
            sum += n;
        }
        return sum;
    }

    public static boolean dp(int[] nums, int sum, int index) {
        if(sum < 0 || index >= nums.length) {
            return false;
        }
        if(sum == 0) {
            return true;
        }
        boolean res = false;
        if(sum - nums[index] < 0) {
            res = dp(nums, sum, index + 1);
        } else {
            res = dp(nums, sum - nums[index], index + 1) || dp(nums, sum, index + 1);
        }
        return res;
    }


    //2.动态规划
    public static boolean canPartition2(int[] nums) {
        int sum = getSums(nums);
        if(sum % 2 == 1) {
            return false;
        }
        //考虑状态和选择
        int m = sum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[m + 1][n + 1];
        for(int i = 0; i <= n; i++) {
            dp[0][i] = true;
        }
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(i - nums[j - 1] < 0) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1] || dp[i - nums[j - 1]][j - 1];
                }
            }
        }
        return dp[m][n];
    }


    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5, 10};
        System.out.println(canPartition2(nums));
    }
}
