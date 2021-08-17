package leetcode.suanfa.labuladong._4._4_2;

import java.util.Arrays;

public class Solution {

    //吃葡萄

    /**
     * 有三种葡萄，每种分别有 a, b, c 颗，现在有三个人，第一个人只吃第一种和第二种葡萄，第二个人只吃第二种和第三种葡萄，第三个人只吃第一种和第三种葡萄。
     * 现在给你输入 a, b, c 三个值，请你适当安排，让三个人吃完所有的葡萄，算法返回吃的最多的人最少要吃多少颗葡萄。
     * @param a
     * @param b
     * @param c
     * @return
     */
    public long solution(long a, long b, long c) {
        long sum = a + b + c;
        long[] nums = {a, b, c};
        Arrays.sort(nums);
        if (nums[0] + nums[1] > nums[2]) {
            return (sum + 2) / 3;
        } else if (nums[2] > (nums[0] + nums[1]) * 2) {
            return (nums[2] + 1) / 2;
        }
        return (sum + 2) / 3;
    }
}
