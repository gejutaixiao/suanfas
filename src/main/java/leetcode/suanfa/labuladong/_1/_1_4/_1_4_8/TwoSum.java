package leetcode.suanfa.labuladong._1._1_4._1_4_8;

import java.util.HashMap;

public class TwoSum {

    //两数之和
    /**
     * 这个问题的最基本形式是这样：给你一个数组和一个整数 target，可以保证数组中存在两个数的和为 target，请你返回这两个数的索引。
     * 比如输入 nums = [3,1,3,6], target = 6，算法应该返回数组 [0,2]，因为 3 + 3 = 6。
     */

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            //如果other存在且不失nums[i]本身
            if(map.containsKey(other) && map.get(other) != i) {
                return new int[]{i, map.get(other)};
            }
        }
        return new int[]{-1, -1};
    }
}
