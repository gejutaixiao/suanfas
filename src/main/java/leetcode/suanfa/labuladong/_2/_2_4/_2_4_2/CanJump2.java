package leetcode.suanfa.labuladong._2._2_4._2_4_2;

public class CanJump2 {

    //跳跃游戏Ⅱ

    public static int canJump(int[] nums) {
        //dp(nums, index)从索引index跳到最后一格，所需要的最小次数
        return dp(nums, 0);
    }
    public static int dp(int[] nums, int index) {
        if(index >= nums.length - 1) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        int steps = nums[index];
        for(int i = 1; i <= steps; i++) {
            res = Math.min(res, dp(nums, index + i) + 1);
        }
        return res;
    }

    public static int canJump2(int[] nums) {
        int farthest = 0, count = 0, end = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if(i == end) {
                count++;
                end = farthest;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump2(nums));
    }
}
