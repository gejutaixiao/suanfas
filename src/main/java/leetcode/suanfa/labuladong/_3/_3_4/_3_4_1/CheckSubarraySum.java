package leetcode.suanfa.labuladong._3._3_4._3_4_1;

import java.util.HashMap;

public class CheckSubarraySum {

    /**
     * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
     *
     * 子数组大小 至少为 2 ，且
     * 子数组元素总和为 k 的倍数。
     * 如果存在，返回 true ；否则，返回 false 。
     *
     * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/continuous-subarray-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    //前缀和主要适用的场景是原始数组不会被修改的情况下，频繁查询某个区间的累加和。
    public static boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (i - j >= 2 && (preSum[i] - preSum[j]) % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkSubarraySum2(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, -1);
        int sum_1 = 0;
        for (int i = 0; i < n; i++) {
            sum_1 += nums[i];
            if (preSum.containsKey(sum_1 % k)) {
                if (i - preSum.get(sum_1 % k) >= 2) {
                    return true;
                }
            } else {
                preSum.put(sum_1 % k, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {23, 2, 6, 4, 7};
        System.out.println(checkSubarraySum(nums, 13));
        System.out.println(checkSubarraySum2(nums, 13));
    }
}
