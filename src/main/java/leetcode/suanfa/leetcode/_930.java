package leetcode.suanfa.leetcode;

import java.util.HashMap;
import java.util.Random;

public class _930 {

    //和相同的二元子数组
    public static int count(int[] arr, int goal) {
        int n = arr.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + arr[i];
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (preSum[i] - preSum[j] == goal) {
                    count++;
                }
            }
        }
        return count;
    }
    public static int count2(int[] arr, int goal) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        int count = 0;
        int sum = 0;
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            count += map.getOrDefault(sum - goal, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[100];
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 100; j++) {
                arr[j] = random.nextInt(10);
            }
            if (count(arr, 5) != count2(arr, 5)) {
                System.err.println("error!!!");
            }
        }
        System.out.println("prefect!");
    }
}
