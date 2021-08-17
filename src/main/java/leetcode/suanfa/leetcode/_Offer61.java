package leetcode.suanfa.leetcode;

import java.util.Arrays;

public class _Offer61 {
    public static boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int min = 14, max = 0;
        int zero = 0;
        for (int i = 0; i < 5; i++) {
            if (i > 0) {
                if (nums[i] == nums[i - 1] && nums[i] != 0) {
                    return false;
                }
            }
            min = nums[i] != 0 ? Math.min(min, nums[i]) : min;
            max = Math.max(max, nums[i]);
            zero = nums[i] == 0 ? zero + 1 : zero;
        }
        return max - min - 1 <= zero || max - min == 4;
    }

    public static void main(String[] args) {
        int[] nums = {11, 9, 0, 0, 0};
        System.out.println(isStraight(nums));
    }
}
