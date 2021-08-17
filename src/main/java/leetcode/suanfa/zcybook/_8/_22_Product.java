package leetcode.suanfa.zcybook._8;

import java.util.Random;

public class _22_Product {

    //不包含本位置值的累乘数组
    /**
     * 给定一个整型数组arr，返回不包含本位置值的累乘数组
     * 例如，arr=[2,3,1,4],返回[12,8,24,6]，即除自己外，其他位置上的累乘
     */

    public static int[] product1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return null;
        }
        int all = 1,count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                all *= arr[i];
            } else {
                count++;
            }
        }
        int[] res = new int[arr.length];
        if (count == 0) {
            for (int i = 0; i < res.length; i++) {
                res[i] = all / arr[i];
            }
        }
        if (count == 1) {
            for (int i = 0; i < res.length; i++) {
                if (arr[i] == 0) {
                    res[i] = all;
                }
            }
        }
        return res;
    }

    /**
     * 不能使用除法
     * @param arr
     * @return
     */
    public static int[] product2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return null;
        }
        int[] res = new int[arr.length];
        res[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res[i] = res[i - 1] * arr[i];
        }
        int temp = 1;
        for (int i = arr.length - 1; i >= 1; i--) {
            res[i] = res[i - 1] * temp;
            temp *= arr[i];
        }
        res[0] = temp;
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[123];
        Random random = new Random();
        long currentTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 123; j++) {
                arr[j] = random.nextInt(123) * (random.nextInt(2) >= 1 ? 1 : -1);
            }
            int[] product1 = product1(arr);
            int[] product2 = product2(arr);
            for (int k = 0; k < product1.length; k++) {
                if (product1[k] != product2[k]) {
                    System.err.println("出现问题了！！！");
                }
            }

        }
        System.out.println("perfect!!!");
    }
}
