package leetcode.suanfa.labuladong._3._3_3._3_3_1;

public class IsPowerOfTwo {

    //判断一个数是不是2的指数
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
}
