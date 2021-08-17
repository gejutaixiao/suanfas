package leetcode.suanfa.labuladong._3._3_3._3_3_6;

public class FindErrorNumber {

    //错误的集合
    /**
     * 给一个长度为 N 的数组 nums，其中本来装着 [1..N] 这 N 个元素，无序。
     * 但是现在出现了一些错误，nums 中的一个元素出现了重复，也就同时导致了另一个元素的缺失。
     * 请你写一个算法，找到 nums 中的重复元素和缺失元素的值。
     */

    public static int[] findErrorNumber(int[] nums) {
        int dup = -1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                dup = index + 1;
            } else {
                nums[index] *= -1;
            }
        }
        int missing = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
            }
        }
        return new int[]{dup, missing};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4};
        int[] errorNumber = findErrorNumber(nums);
        System.out.println(errorNumber[0] + ", " + errorNumber[1]);
    }
}
