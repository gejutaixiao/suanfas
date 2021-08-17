package leetcode.suanfa.labuladong._1._1_4._1_4_8_1;

import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    //四数之和

    /**
     * 返回一个数组中，任意四个数之和等于给定值的结果
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int lo = 0;
        int n = nums.length;
        while (lo < n) {
            int left = nums[lo];
            List<List<Integer>> lists = threeSum(nums, target - left, lo + 1);
            for (List<Integer> list : lists) {
                list.add(0, left);
                res.add(list);
            }
            while (lo < n && nums[lo] == left) lo++;
        }
        return res;
    }
    public static List<List<Integer>> threeSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int lo = start;
        int n = nums.length;
        while (lo < n) {
            int left = nums[lo];
            List<List<Integer>> lists = twoSum(nums, target - left, lo + 1);
            for (List<Integer> list : lists) {
                list.add(0, left);
                res.add(list);
            }
            while (lo < n && nums[lo] == left) lo++;
        }
        return res;
    }
    public static List<List<Integer>> twoSum(int[] nums, int target, int start) {
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

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> lists = fourSum(nums, 0);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
