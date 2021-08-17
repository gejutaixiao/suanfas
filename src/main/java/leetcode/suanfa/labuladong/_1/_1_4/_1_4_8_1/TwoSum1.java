package leetcode.suanfa.labuladong._1._1_4._1_4_8_1;

public class TwoSum1 {

    //两数之和

    /**
     * 给定一个已经排序好的数组，找出目标和等于给定值的两个数
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{nums[left], nums[right]};
            } else if (target > sum) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 7, 8, 10};
        System.out.println(twoSum(nums, 15)[1]);
    }
}
