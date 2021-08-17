package leetcode.suanfa.labuladong._3._3_4._3_4_1;

import java.util.HashMap;

public class FindMaxLength {
    /**
     * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
     */

    //利用前缀和
    public static int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                preSum[i + 1] = preSum[i] - 1;
            } else {
                preSum[i + 1] = preSum[i] + 1;
            }
        }
        int maxLength = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (preSum[i] == preSum[j]) {
                    maxLength = Math.max(maxLength, i - j);
                }
            }
        }
        return maxLength;
    }

    public static int findMaxLength2(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> preSum = new HashMap<>();
        int counter = 0;
        int maxLength = 0;
        preSum.put(counter, -1);
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                counter--;
            } else {
                counter++;
            }
            if (preSum.containsKey(counter)) {
                maxLength = Math.max(maxLength, i - preSum.get(counter));
            } else {
                preSum.put(counter, i);
            }
        }
        return maxLength;
    }


    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0};

        System.out.println(findMaxLength(nums));
        System.out.println(findMaxLength2(nums));
    }
}
