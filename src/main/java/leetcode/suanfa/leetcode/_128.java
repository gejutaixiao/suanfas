package leetcode.suanfa.leetcode;

import java.util.HashSet;

public class _128 {

    //最长连续序列
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 1;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int cur = num;
                int curLong = 1;
                while (set.contains(cur + 1)) {
                    cur++;
                    curLong++;
                }
                res = Math.max(res, curLong);
            }
        }
        return res;
    }
}
