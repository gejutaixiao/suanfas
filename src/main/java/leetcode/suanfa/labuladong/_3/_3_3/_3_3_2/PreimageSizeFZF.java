package leetcode.suanfa.labuladong._3._3_3._3_3_2;

public class PreimageSizeFZF {

    /**
     * 输入一个非负整数 K，请你计算有多少个 n，满足 n! 的结果末尾恰好有 K 个 0。
     * 比如说输入 K = 1，算法返回 5，因为 5!,6!,7!,8!,9! 这 5 个阶乘的结果最后只有一个 0，即有 5 个 n 满足条件。
     * @param K
     * @return
     */
    public static int preimageSizeFZF(int K) {
        return right_num(K) - left_num(K) + 1;
    }

    //寻找左边界
    public static int left_num(int target) {
        long left = 1;
        long right = Long.MAX_VALUE;
        while (left < right) {
            long mid = left + (right - left) / 2;
            int n = trailingZeroes(mid);
            if (n > target) {
                right = mid;
            } else if (n < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (int) left;
    }

    //寻找右边界
    public static int right_num(int target) {
        long left = 1;
        long right = Long.MAX_VALUE;
        while (left < right) {
            long mid = left + (right - left) / 2;
            int n = trailingZeroes(mid);
            if (n > target) {
                right = mid;
            } else if (n < target) {
                left = mid + 1;
            } else {
                left = mid + 1;
            }
        }
        return (int) (left - 1);
    }

    public static int trailingZeroes(long n) {
        int res = 0;
        for (long d = n; d / 5 > 0; d /= 5) {
            res += d / 5;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(preimageSizeFZF(1));
    }
}
