package leetcode.suanfa.labuladong._1._1_4._1_4_7;

public class RemoveDuplicates {

    //删除排序数组中的重复元素
    /**
     * 给你一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度
     */

    public static int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;
        while(fast < nums.length) {
            if(nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 3, 4, 5, 5, 6};
        System.out.println(removeDuplicates(nums));
    }
}
