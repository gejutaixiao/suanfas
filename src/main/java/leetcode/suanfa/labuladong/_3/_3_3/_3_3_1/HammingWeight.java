package leetcode.suanfa.labuladong._3._3_3._3_3_1;

public class HammingWeight {

    //计算汉明权重
    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
