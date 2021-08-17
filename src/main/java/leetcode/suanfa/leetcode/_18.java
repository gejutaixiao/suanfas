package leetcode.suanfa.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _18 {

    //四数之和

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            List<List<Integer>> lists = threeSum(nums, target - num, i + 1);
            for (List<Integer> list : lists) {
                list.add(0, num);
                res.add(list);
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }
    public List<List<Integer>> threeSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = start; i < nums.length; i++) {
            int num = nums[i];
            List<List<Integer>> lists = twoSum(nums, target - num, i + 1);
            for (List<Integer> list : lists) {
                list.add(0, num);
                res.add(list);
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }
    public List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
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
        return res;
    }
}
