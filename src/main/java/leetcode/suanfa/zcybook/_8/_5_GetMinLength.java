package leetcode.suanfa.zcybook._8;

public class _5_GetMinLength {

    //需要排序的最短子数组
    /**
     * 给定一个无序数组arr, 求出需要排序的最短子数组长度
     * 例如：arr = [1, 5 ,3 ,4, 2, 6 ,7]返回4，因为只有[5, 3, 4, 2]需要排序
     */

    public static int getMinLength(int[] arr) {
        int noMinIndex = -1;
        int n = arr.length;
        int min = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > min) {
                noMinIndex = i;
            } else {
                min = Math.min(min, arr[i]);
            }
        }
        if (noMinIndex == -1) {
            return 0;
        }
        int max = arr[0];
        int noMaxIndex = 0;
        for (int i = 1; i < n; i++) {
            if (max > arr[i]) {
                noMaxIndex = i;
            } else {
                max = Math.max(max, arr[i]);
            }
        }
        return noMaxIndex - noMinIndex + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 2, 6, 7};
        System.out.println(getMinLength(arr));
    }
}
