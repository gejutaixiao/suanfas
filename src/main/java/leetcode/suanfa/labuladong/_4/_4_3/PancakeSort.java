package leetcode.suanfa.labuladong._4._4_3;

import java.util.ArrayList;
import java.util.List;

public class PancakeSort {

    //煎饼排序

    /**
     * 烧饼排序是个很有意思的实际问题：假设盘子上有 n 块面积大小不一的烧饼，你如何用一把锅铲进行若干次翻转，让这些烧饼的大小有序（小的在上，大的在下）？
     * @param nums
     * @return
     */
    static List<Integer> res = new ArrayList<>();
    static List<Integer> pancakeSort(int[] nums) {
        pancakeSort(nums, nums.length);
        return res;
    }
    static void pancakeSort(int[] nums, int n) {
        if (n == 1) return;
        //寻找最大的煎饼索引
        int maxIndex = 0, maxPancake = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > maxPancake) {
                maxIndex = i;
                maxPancake = nums[i];
            }
        }
        //首先将最大的煎饼翻转到最上方
        swap(nums, 0, maxIndex);
        res.add(maxIndex + 1);
        //将最上方的煎饼翻转到最下方
        swap(nums, 0, n - 1);
        res.add(n);

        //递归翻转
        pancakeSort(nums, n - 1);
    }
    static void swap(int[] nums, int i, int j) {
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4, 1};
        List<Integer> list = pancakeSort(nums);
        for (Integer integer : list) {
            System.out.print(integer);
        }
        System.out.println();
        for (int num : nums) {
            System.out.print(num);
        }
    }
}
