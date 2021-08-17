package leetcode.suanfa.labuladong._1._1_4._1_4_8_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TwoSum2 {

    //两数之和Ⅱ

    /**
     * 给定一个数组和一个指定值，找出数组中所有和可能等于target的两个数，数组中的数字可能会重复，要求结果中不能含有重复值
     * @param nums
     * @param target
     * @return
     */
    public static List<int[]> twoSum(int[] nums, int target) {
        ArrayList<int[]> res = new ArrayList<>();
        //1.先排序
        Arrays.sort(nums);
        //2.双指针
        int n = nums.length;
        int li = 0, ho = n - 1;
        while (li < ho) {
            int sum = nums[li] + nums[ho];
            if (target == sum) {
                res.add(new int[]{nums[li], nums[ho]});
                li++;
                ho--;
                while (li < n && nums[li] == nums[li - 1]) {
                    li++;
                }
                while (ho >= 0 && nums[ho] == nums[ho + 1]) {
                    ho--;
                }
            } else if (target > sum) {
                ho--;
                while (ho >= 0 && nums[ho] == nums[ho + 1]) {
                    ho--;
                }
            } else {
                li++;
                while (li < n && nums[li] == nums[li - 1]) {
                    li++;
                }
            }
        }
        return res;
    }

    public static List<int[]> twoSum2(int[] nums, int target) {
        ArrayList<int[]> res = new ArrayList<>();
        //1.先排序
        Arrays.sort(nums);
        //2.双指针取数组的两端
        int li = 0, ho = nums.length - 1;
        while (li < ho) {
            int left = nums[li], right = nums[ho];
            int sum = left + right;
            if (sum == target) {
                res.add(new int[]{left, right});
                while (li < ho && nums[li] == left) li++;
                while (li < ho && nums[ho] == right) ho--;
            } else if (target > sum) {
                while (li < ho && nums[li] == left) li++;
            } else {
                while (li < ho && nums[ho] == right) ho--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int[] nums = new int[30];
            for (int k = 0; k < 30; k++) {
                nums[k] = random.nextInt(60);
            }
            List<int[]> list = twoSum(nums, 60);
            List<int[]> list1 = twoSum2(nums, 60);
            int size = list.size();
            int size1 = list.size();
            if (size != size1) {
                System.err.println("出现错误！！！");
            }
            for (int j = 0; j < list.size(); j++) {
                int[] ints = list.get(j);
                int[] ints1 = list1.get(j);
                if (ints[0] != ints1[0] || ints[1] != ints1[1]) {
                    System.err.println("出现错误！！！   90");
                }
            }
        }
        System.out.println("毫无问题！！！");
//        int[] nums = {1,3,1,2,2,3};
//        List<int[]> list = twoSum2(nums, 4);
//        for (int[] ints : list) {
//            for (int i : ints) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }
    }
}
