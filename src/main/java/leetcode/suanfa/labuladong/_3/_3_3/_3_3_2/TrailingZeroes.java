package leetcode.suanfa.labuladong._3._3_3._3_3_2;

public class TrailingZeroes {

    //阶乘后的0
    /**
     * 输入一个非负整数 n，请你计算阶乘 n! 的结果末尾有几个 0。
     */

    public static int trailingZeroes(int n) {
        int res = 0;
        for (int d = n; d / 5 > 0; d /= 5) {
            res += d / 5;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(125));
    }
}
