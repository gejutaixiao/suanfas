package leetcode.suanfa.labuladong._1._1_4._1_4_8_1;

import java.util.*;

public class ThreeSum {

    //三数之和

    /**
     * 给定一个无序数组和一个指定数，返回数组中任意三个数的和等于指定数的结果，并且结果中不能有重复值
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int left = nums[i];
            List<int[]> list = twoSum(nums, target - left, i + 1);
            for (int[] ints : list) {
                ArrayList<Integer> res1 = new ArrayList<>();
                res1.add(left);
                res1.add(ints[0]);
                res1.add(ints[1]);
                res.add(res1);
            }
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }

    public static List<List<Integer>> threeSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        int lo = 0;
        while (lo < n) {
            int left = nums[lo];
            List<int[]> list = twoSum(nums, target - left, lo + 1);
            for (int[] ints : list) {
                ArrayList<Integer> res1 = new ArrayList<>();
                res1.add(left);
                res1.add(ints[0]);
                res1.add(ints[1]);
                res.add(res1);
            }
            while (lo < n && nums[lo] == left) {
                lo++;
            }
        }
        return res;
    }
    public static List<int[]> twoSum(int[] nums, int target, int start) {
        ArrayList<int[]> res = new ArrayList<>();
        //其中nums是已经排好序的
        int li = start, ho = nums.length - 1;
        List<Integer> rr = new ArrayList<>();
        while (li < ho) {
            int left = nums[li], right = nums[ho];
            int sum = left + right;
            if (sum == target) {
                res.add(new int[]{left, right});
                while (li < ho && nums[li] == left) li++;
                while (li < ho && nums[ho] == right) ho--;
            } else if (sum > target) {
                while (li < ho && nums[ho] == right) ho--;
            } else {
                while (li < ho && nums[li] == left) li++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            int[] nums = new int[100];
            for (int k = 0; k < 100; k++) {
                nums[k] = random.nextInt(30);
            }
            HashSet<String> set = new HashSet<>();
            List<List<Integer>> lists1 = threeSum(nums, 30);
            List<List<Integer>> lists2 = threeSum2(nums, 30);
            for (List<Integer> integers : lists1) {
                StringBuffer sb = new StringBuffer();
                for (Integer integer : integers) {
                    sb.append(integer);
                    sb.append("-");
                }
                set.add(sb.toString());
            }
            for (List<Integer> integers : lists2) {
                StringBuffer sb = new StringBuffer();
                for (Integer integer : integers) {
                    sb.append(integer);
                    sb.append("-");
                }
                String s = sb.toString();
                if (!set.contains(s)) {
                    System.err.println("出现错误！！！");
                } else {
                    set.remove(s);
                }
            }
            if (set.size() != 0) {
                System.err.println("出现错误！！！");
            }
        }
        System.out.println("毫无问题！！！");
    }
}
