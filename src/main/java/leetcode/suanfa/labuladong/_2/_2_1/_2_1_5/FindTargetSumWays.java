package leetcode.suanfa.labuladong._2._2_1._2_1_5;

import java.util.HashMap;

public class FindTargetSumWays {

    //目标和
    /**
     * 给你一个整数数组 nums 和一个整数 target 。
     *
     * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
     *
     * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
     * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
     *
     */
    static int result = 0;
    public static int findTargetSumWays(int[] nums, int target) {
        if(nums.length == 0) {
            return 0;
        }
        backtrack(nums, 0, target);
        return result;
    }
    public static void backtrack(int[] nums, int i, int rest) {
        //base case
        if (i == nums.length) {
            if(rest == 0) {
                result++;
            }
            return;
        }

        //取“-”号
        rest += nums[i];
        //穷举nums[i + 1]
        backtrack(nums, i + 1, rest);
        //撤销选择
        rest -= nums[i];

        //取“+”号
        rest -= nums[i];
        //穷举nums[i + 1]
        backtrack(nums, i + 1, rest);
        //撤销选择
        rest += nums[i];
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(findTargetSumWays2(nums, 3));
    }

    public static int findTargetSumWays2(int[] nums, int target) {
        if(nums.length == 0) {
            return 0;
        }
        return dp(nums, 0, target);
    }
    static HashMap<String, Integer> map = new HashMap<>();
    public static int dp(int[] nums, int i, int rest) {
        //base case
        if(i == nums.length) {
            if(rest == 0) {
                return 1;
            }
            return 0;
        }
        //设置i，rest的key
        String key = i + "" + rest;
        if(map.containsKey(key)) {
            return map.get(key);
        }
        int result = dp(nums, i + 1, rest - nums[i]) + dp(nums, i + 1, rest + nums[i]);
        map.put(key, result);
        return result;
    }
}
