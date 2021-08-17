package leetcode.suanfa.labuladong._3._3_3._3_3_3;

import java.util.Arrays;

public class CountPrimes {

    //计算质数
    /**
     * 素数的定义看起来很简单，如果一个数如果只能被 1 和它本身整除，那么这个数就是素数。
     */

    //计算[2, n) 中有几个质数
    public static int countPrimes1(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime1(i)) {
                count++;
            }
        }
        return count;
    }
    public static boolean isPrime1(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static int countPrimes2(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime2(i)) {
                count++;
            }
        }
        return count;
    }
    public static boolean isPrime2(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int countPrimes3(int n) {
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes, true);
        for (int i = 2; i * i < n; i++) {
            if (isPrimes[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrimes[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes1(10));
        System.out.println(countPrimes2(10));
        System.out.println(countPrimes3(10));
    }
}
