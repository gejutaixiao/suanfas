package leetcode.suanfa.zcybook._8;

public class _9_1_PrintUniquePair {

    //不重复打印排序数组中相加和为给定值的所有二元数组
    /**
     * 给定排序数组arr和整数k，不重复打印arr中所有相加和为k的不降序二元组
     */

    public static void printUniquePair(int[] arr, int k) {
        int lo = 0, hi = arr.length - 1;
        int sum = 0;
        while (lo < hi) {
            int left = arr[lo], right = arr[hi];
            sum = left + right;
            if (sum == k) {
                System.out.print(left + " ");
                System.out.println(right);
                while (lo < hi && arr[lo] == left) lo++;
                while (lo < hi && arr[hi] == right) hi--;
            } else if (sum > k) {
                while (lo < hi && arr[hi] == right) hi--;
            } else {
                while (lo < hi && arr[lo] == left) lo++;
            }
        }
    }
}
