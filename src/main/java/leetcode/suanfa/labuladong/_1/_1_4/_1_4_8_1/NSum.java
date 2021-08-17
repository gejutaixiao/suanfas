package leetcode.suanfa.labuladong._1._1_4._1_4_8_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NSum {

    //N数之和

    public static List<List<Integer>> nSum(int[] nums, int target, int n) {
        Arrays.sort(nums);
        int len = nums.length;
        if (len < n || n < 2) {
            return new ArrayList<>();
        }
        return nSums(nums, target, 0, n);
    }
    public static List<List<Integer>> nSums(int[] nums, int target, int start, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 2) {
            int lo = start, hi = nums.length - 1;
            while (lo < hi) {
                int left = nums[lo], right = nums[hi];
                int sum = left + right;
                if (sum == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(left);
                    list.add(right);
                    res.add(list);
                    while (lo < hi && nums[lo] == left) lo++;
                    while (lo < hi && nums[hi] == right) hi--;
                } else if (sum > target) {
                    while (lo < hi && nums[hi] == right) hi--;
                } else {
                    while (lo < hi && nums[lo] == left) lo++;
                }
            }
        } else {
            //递归调用n-1的和
            int len = nums.length;
            int lo = start;
            while (lo < len) {
                int left = nums[lo];
                List<List<Integer>> lists = nSums(nums, target - left, lo + 1, n - 1);
                for (List<Integer> list : lists) {
                    list.add(0, left);
                    res.add(list);
                }
                while (lo < len && nums[lo] == left) lo++;
            }
        }
        return res;
    }
}
