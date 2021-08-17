package leetcode.suanfa.labuladong._3._3_4._3_4_2;

public class Difference {

    public int[] diff;
    public Difference(int[] nums) {
        int n = nums.length;
        diff = new int[n];
        diff[0] = nums[0];
        for (int i = 1; i < n; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }
    public void increment(int i, int j, int val) {
        diff[i] += val;
        if (j + 1 < diff.length) {
            diff[j + 1] -= val;
        }
    }
    public int[] result() {
        int n = diff.length;
        int[] res = new int[n];
        res[0] = diff[0];
        for (int i = 1; i < n; i++) {
            res[i] = diff[i] + res[i - 1];
        }
        return res;
    }
}
