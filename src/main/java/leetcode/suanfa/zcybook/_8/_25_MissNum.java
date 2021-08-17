package leetcode.suanfa.zcybook._8;

import java.util.Arrays;

public class _25_MissNum {

    //数组中未出现的最小正整数

    public static int missNum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        Arrays.sort(arr);
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0 && arr[i] != ++res) {
                return res;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 2, 1, 4, 5};
        System.out.println(missNum(arr));
    }
}
