package leetcode.suanfa.labuladong._1._1_4._1_4_3;

import java.awt.image.RGBImageFilter;

public class TwoSum {

    //两数之和Ⅱ

    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int sum = nums[left] + nums[right];
            if(sum == target) {
                return new int[]{left + 1, right + 1};
            } else if(sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }
}
