package leetcode.suanfa.zcybook._8;

import java.util.HashMap;
import java.util.Random;

public class _11_3_MaxLength {

    /**
     * 给定一个无序数组arr，其中元素只是1或0.求arr所有子数组中0和1个数相等的最长子数组长度。
     */

    //前缀和

    public static int maxLength(int[] arr) {
        int n = arr.length;
        int[] preSum = new int[n + 1];
        int len = -1;
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + (arr[i] == 1 ? 1 : -1);
        }
        for (int i = 1; i < n + 1; i++) {
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
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] == 1 ? 1 : -1;
            if (map.containsKey(sum)) {
                len = Math.max(len, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return len;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[100];
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < 100; j++) {
                arr[j] = random.nextInt(2) >= 1 ? 1 : 0;
            }
            if (maxLength(arr) != maxLength2(arr)) {
                System.err.println("出现错误！！！");
            }
        }
        System.out.println("毫无问题！！！");
    }
}
