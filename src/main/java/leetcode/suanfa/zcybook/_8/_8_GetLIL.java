package leetcode.suanfa.zcybook._8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class _8_GetLIL {

    //最长的可整合子数组的长度
    /**
     * 如果一个数组在排序之后，每相邻两个数差的绝对值都为1，则该数组为可整合数组。
     */

    public static int getLIL1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (isIntegerted(arr, i, j)) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }
    private static boolean isIntegerted(int[] arr, int i, int j) {
        int[] copy = Arrays.copyOfRange(arr, i, j + 1);
        Arrays.sort(copy);
        for (int k = 1; k < copy.length; k++) {
            if (copy[k] != copy[k - 1] + 1) {
                return false;
            }
        }
        return true;
    }

    public static int getLIL2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int len = 0;
        int max = 0;
        int min = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;

            for (int j = i; j < arr.length; j++) {
                if (set.contains(arr[j])) {
                    break;
                }
                set.add(arr[j]);
                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);
                if (max - min == j - i) {
                    len = Math.max(len, j - i + 1);
                }
            }
            set.clear();
        }
        return len;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[23];
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 23; j++) {
                arr[j] = random.nextInt(13);
            }
            if (getLIL1(arr) != getLIL2(arr)) {
                System.err.println("出现错误！");
            }
        }
        System.out.println("毫无问题！");
    }

}
