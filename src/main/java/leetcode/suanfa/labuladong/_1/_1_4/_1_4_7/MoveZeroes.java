package leetcode.suanfa.labuladong._1._1_4._1_4_7;

public class MoveZeroes {

    //移动零
    /**
     * 给你输入一个数组 nums，请你原地修改，将数组中的所有值为 0 的元素移到数组末尾，
     */

    public void moveZeroes(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right) {
            while(nums[left] != 0) {
                left++;
            }
            while(nums[right] == 0) {
                right--;
            }
            nums[left] = nums[right];
            nums[right] = 0;
            left++;
            right--;
        }
    }

    public void moveZeroes2(int[] nums) {
        int p = removeElement(nums, 0);
        for(; p < nums.length; p++) {
            nums[p] = 0;
        }
    }
    public int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        while(fast < nums.length) {
            if(nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }
}
