package leetcode.suanfa.leetcode;

import java.util.Arrays;

public class _1818 {

    //绝对差值和
    /**
     * 给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。
     *
     * 数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的 总和（下标从 0 开始）。
     *
     * 你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。
     *
     * 在替换数组 nums1 中最多一个元素 之后 ，返回最小绝对差值和。因为答案可能很大，所以需要对 109 + 7 取余 后返回。
     *
     * |x| 定义为：
     *
     * 如果 x >= 0 ，值为 x ，或者
     * 如果 x <= 0 ，值为 -x
     *
     */

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int mod = 1000000007;
        int n = nums1.length;;
        int[] help = new int[n];
        System.arraycopy(nums2, 0, help, 0, n);
        Arrays.sort(help);
        int sum = 0, maxn = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + diff) / mod;
            int i1 = binarySearch(help, nums2[i]);
            if (i1 > 0) {
                maxn = Math.max(maxn, diff - (nums2[i] - help[i1 - 1]));
            }
            if (i1 < n) {
                maxn = Math.max(maxn, diff - (help[i1] - nums2[i]));
            }
        }
        return (sum - maxn + mod) % mod;
    }
    public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        if (nums[right] < target) {
            return right;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
