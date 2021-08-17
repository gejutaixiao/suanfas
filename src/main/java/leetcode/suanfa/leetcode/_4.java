package leetcode.suanfa.leetcode;

import java.sql.SQLOutput;

public class _4 {

    //寻找两个正序数组的中位数
    /**
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
     *
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     *
     */

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] nums = new int[m + n];
        int index = 0;
        int index1 = 0, index2 = 0;
        while (index < m + n) {
            if (index1 < m && index2 < n) {
                if (nums1[index1] > nums2[index2]) {
                    nums[index] = nums2[index2];
                    index2++;
                } else {
                    nums[index] = nums1[index1];
                    index1++;
                }
                index++;
            } else if (index1 >= m) {
                nums[index++] = nums2[index2++];
            } else {
                nums[index++] = nums1[index1++];
            }
        }
        int len = nums.length;
        if (len % 2 == 1) {
            return nums[len / 2];
        }
        return (double)(nums[len / 2 - 1] + nums[len / 2]) / 2;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
