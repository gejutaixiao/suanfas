package leetcode.suanfa.labuladong._2._2_1._2_1_1;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.HashMap;

public class Fib {

    //斐波那契数列

    //1.暴力递归
    public static int fib1(int N) {
        if(N == 1 || N == 2) {
            return 1;
        }
        return fib1(N - 1) + fib1(N - 2);
    }

    //2.带备忘录的递归解法
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static int fib2(int N) {
        if(N == 1 || N == 2) {
            return 1;
        }
        if(map.containsKey(N)) {
            return map.get(N);
        }
        int num = fib2(N - 1) + fib2(N - 2);
        map.put(N, num);
        return num;
    }

    //3.dp数组的迭代解法
    public static int fib3(int N) {
        if(N == 1 || N == 2) {
            return 1;
        }
        int[] dp = new int[N + 1];
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }

    //4.状态压缩后的迭代解法
    public static int fib4(int N) {
        if(N == 1 || N == 2) {
            return 1;
        }
        int pre = 1, cur = 1;
        for(int i = 3; i <= N; i++) {
            int sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return cur;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(fib1(40));
        System.out.println(System.currentTimeMillis() - start);
    }
}
