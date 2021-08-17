package leetcode.suanfa.zcybook._8;

import java.util.HashMap;
import java.util.Random;

public class _11_2_MaxLength {

    //给定一个无序数组arr，其中元素可正、可负、可0.求arr所有的子数组中正数与负数个数相等的最长子数组长度

    //前缀和
    public static int maxLength1(int[] arr) {
        int len = -1;
        int[] preSum = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                preSum[i + 1] = preSum[i] + 1;
            } else if (arr[i] < 0) {
                preSum[i + 1] = preSum[i] - 1;
            } else {
                preSum[i + 1] = preSum[i];
            }
        }
        for (int i = 1; i < preSum.length; i++) {
            for (int j = 0; j < i; j++) {
                if (preSum[i] == preSum[j]) {
                    len = Math.max(len, i - j);
                }
             }
        }
        return len;
    }

    public static int maxLength2(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = -1;
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                sum += 1;
            } else if (arr[i] < 0) {
                sum += -1;
            }
            if (map.containsKey(sum)) {
                len = Math.max(len, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] arr = new int[100];
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 100; j++) {
                arr[j] = (random.nextInt(2) >= 1 ? 1 : -1) * random.nextInt(10);
            }
            if (maxLength2(arr) != maxLength1(arr)) {
                System.err.println("出现错误！！！");
            }
        }
        System.out.println("毫无问题！！！");
    }
}
