package leetcode.suanfa.zcybook._8;

public class _15_Modify {

    //奇数下标都是奇数或偶数下标都是偶数
    /**
     * 给定一个长度不小于2的数组arr，实现一个函数调整arr，要么让所有偶数下标都是偶数，要么让所有奇数下标都是奇数
     */

    /**
     * 一直和最后一个数进行替换，偶数或者奇数总会有一个先遍历完
     * @param arr
     */
    public static void modify(int[] arr) {
        int left = 0, right = 1;
        int n = arr.length - 1;
        while (left <= n && right <= n) {
            if ((arr[n] & 1) == 1) {  //为奇数
                swap(arr, n, right);
                right += 2;
            } else {
                swap(arr, n, left);
                left += 2;
            }
        }
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 1, 4, 2, 514};
        modify(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + ": " + arr[i]);
        }
    }

}
