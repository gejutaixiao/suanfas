package leetcode.suanfa.labuladong._3._3_4._3_4_1;

import java.util.HashMap;

public class SubArraySum {

    //和为k的子数组

    /**
     * 算出一共有几个和为 k 的子数组。
     * @param nums
     * @param k
     * @return
     *
     * 利用前缀和数组来做
     */

    public static int subArraySum1(int[] nums, int k) {
        int n = nums.length;
        //preSum[i]就是nums[0, ..., i - 1] 的和
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int count = 0;
        for (int i = 1; i < preSum.length; i++) {
            for (int j = 0; j < i; j++) {
                if (preSum[i] - preSum[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int subArraySum2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int preSum = 0;
        int count = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            int tmp = preSum - k;
            if (map.containsKey(tmp)) {
                count += map.get(tmp);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        System.out.println(subArraySum1(nums, 2));
        System.out.println(subArraySum2(nums, 2));
    }
}
