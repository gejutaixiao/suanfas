package leetcode.suanfa.zcybook._8;

public class _12_MaxLength {

    //未排序数组中累加和小于或等于给定值的最长子数组长度
    /**
     * 给定一个无序数组arr，其中元素可正、可负、可0，给定一个整数k。
     * 求arr所有的子数组中累加和小于或等于k的最长子数组长度。
     */

    public static int maxLength(int[] arr, int k) {
        int n = arr.length;
        int[] h = new int[n + 1];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            h[i + 1] = Math.max(h[i], sum);
        }
        int len = 0, res = 0, pre = 0;
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            pre = getLessIndex(h, sum - k);
            len = pre == -1 ? 0 : i - pre + 1;
            res = Math.max(res, len);
        }
        return res;
    }

    private static int getLessIndex(int[] h, int num) {

        int lo = 0, hi = h.length - 1;
        int mid = 0;
        int res = -1;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (h[mid] >= num) {
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return res;
    }
}
