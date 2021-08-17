package leetcode.suanfa.labuladong._3._3_3._3_3_1;

public class SingleNumber {

    //查找只出现一次的数字
    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }
}
