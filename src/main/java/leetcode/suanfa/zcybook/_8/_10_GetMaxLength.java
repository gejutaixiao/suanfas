package leetcode.suanfa.zcybook._8;

public class _10_GetMaxLength {

    //未排序正数数组中累加和为给定值的最长子数组长度
    /**
     * 给定一个数组arr，该数组无序，但每个值均为正数，再给定一个正数k。
     * 求arr的所有子数组中所有元素相加和为k的最长组数组长度
     * arr = [1,2,1,1,1],k=3
     */

    public static int getMaxLength(int[] arr, int k) {
        int left = 0, right = 0;
        int sum = arr[0];
        int n = arr.length;
        int len = 0;
        while (right < n) {
            if (sum == k) {
                len = Math.max(len, right - left + 1);
                sum -= arr[left++];
            } else if (sum > k) {
                sum -= arr[left++];
            } else {
                right++;
                if (right == n) {
                    break;
                }
                sum += arr[right];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 1, 1};
        System.out.println(getMaxLength(arr, 3));
    }
}
