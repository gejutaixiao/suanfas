package leetcode.suanfa.zcybook._8;

public class _6_1_PrintHalfMajor {

    //在数组中找到出现次数大于N/K的数
    /**
     * 给定一个整型数组arr，打印其中出现次数大于一半的数，如果没有这样的数，打印提示信息
     */

    /**
     * 一次在数组中删除两个不同的数，不停地删除，直到剩下来的数只有一种，如果这个数出现的次数大于一半，这个数最后一定会剩下来
     * @param arr
     */
    public static void printHalfMajor(int[] arr) {
        int cand = 0, times = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (times == 0) {
                cand = arr[i];
                times = 1;
            } else if (cand == arr[i]) {
                times++;
            } else {
                times--;
            }
        }
        times = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == cand) {
                times++;
            }
        }
        if (times > n / 2) {
            System.out.println(cand);
        } else {
            System.out.println("no such number.");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 1, 1, 1};
        printHalfMajor(arr);
    }
}
