package leetcode.suanfa.leetcode;

import java.util.Arrays;

public class _413 {

    //等差数列划分
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }
        int[] tmp = new int[n - 1];
        Arrays.sort(nums);
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = nums[i + 1] - nums[i];
        }
        int left = 0, right = 0;
        int res = 0;
        while (right < tmp.length) {
            if (tmp[right] != tmp[left]) {
                res += (right - left - 1) * (right - left) / 2;
                left = right;
            }
            right++;
        }
        res += (right - left - 1) * (right - left) / 2;
        return res;
    }
}
