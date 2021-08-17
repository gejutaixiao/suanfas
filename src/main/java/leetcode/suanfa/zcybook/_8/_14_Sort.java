package leetcode.suanfa.zcybook._8;

public class _14_Sort {

    //自然数组的排序
    /**
     * 给定一个长度为N的整型数组arr，其中有N个互补相等的自然数1~N，请实现arr的排序，但是不要把下标0~N-1位置上的数通过直接赋值的方式替换成1~N
     */

    public static void sort1(int[] arr) {
        int temp = 0, next = 0;
        for (int i = 0; i < arr.length; i++) {
            temp = arr[i];
            while (arr[i] != i + 1) {
                next = arr[temp - 1];
                arr[temp - 1] = temp;
                temp = next;
            }
        }
    }

    public static void sort2(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i + 1) {
                temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
