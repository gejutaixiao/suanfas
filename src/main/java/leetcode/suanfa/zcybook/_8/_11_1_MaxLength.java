package leetcode.suanfa.zcybook._8;

import java.util.HashMap;
import java.util.Random;

public class _11_1_MaxLength {

    //未排序数组中累加和为给定值的最长子数组系列问题
    /**
     * 给定一个无序数组arr，其中元素可正、可负、可0，给定一个整数k。求arr所有的子数组累加和为k的最长数组长度
     */

    //前缀和数组
    //暴力解法
    public static int maxLength(int[] arr, int k) {
        int len = -1;
        int[] preArr = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            preArr[i + 1] = preArr[i] + arr[i];
        }
        for (int i = 1; i < preArr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (preArr[i] - preArr[j] == k) {
                    len = Math.max(len, i - j);
                }
            }
        }
        return len;
    }

    public static int maxLength2(int[] arr, int k) {
        int len = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                len = Math.max(len, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] arr = new int[30];
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 30; j++) {
                arr[j] = (random.nextInt(2) >= 1 ? 1 : -1) * random.nextInt(100);
            }
            int k = random.nextInt(1000);
            if (maxLength(arr, k) != maxLength2(arr, k)) {
                System.err.println("出现错误！！！");
            }
        }
        System.out.println("毫无问题！！！");
    }
}
