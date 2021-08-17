package leetcode.suanfa.leetcode;

public class _343 {

    //整数拆分

    /**
     * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
     * 背包问题
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        int sqrt = (int)Math.sqrt(n);
        int num = n / sqrt;
        int k = n % sqrt;
        int res = 1;
        for (int i = 0; i < num; i++) {
            if (k > 0) {
                res *= (sqrt + 1);
                k--;
            } else {
                res *= sqrt;
            }
        }
        return res;
    }
}
