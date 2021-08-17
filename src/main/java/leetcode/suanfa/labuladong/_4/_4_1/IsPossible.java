package leetcode.suanfa.labuladong._4._4_1;

import java.util.HashMap;

public class IsPossible {

    //分割数组为连续子序列

    /**
     * 给你输入一个升序排列的数组 nums（可能包含重复数字），请你判断 nums 是否能够被分割成若干个长度至少为 3 的子序列，每个子序列都由连续的整数组成。
     * @param nums
     * @return
     */
    public static boolean isPossible(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> need = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (freq.get(num) == 0) {
                continue;
            }
            // 将当前数接到已存在的序列后面
            if (need.containsKey(num) && need.get(num) > 0) {
                freq.put(num, freq.get(num) - 1);
                need.put(num, need.get(num) - 1);
                need.put(num + 1, need.getOrDefault(num + 1, 0) + 1);

                // 将当前数作为一个新序列的开头
            } else if (freq.get(num) > 0 && freq.get(num + 1) > 0 && freq.get(num + 2) > 0) {
                freq.put(num, freq.get(num) - 1);
                freq.put(num + 1, freq.get(num + 1) - 1);
                freq.put(num + 2, freq.get(num + 2) - 1);
                need.put(num + 3, need.getOrDefault(num + 3, 0) + 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4, 5, 6, 7};
        System.out.println(isPossible(nums));
    }
}
