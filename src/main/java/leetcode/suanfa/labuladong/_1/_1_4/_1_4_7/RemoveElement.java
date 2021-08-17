package leetcode.suanfa.labuladong._1._1_4._1_4_7;

public class RemoveElement {

    //移除元素
    /**
     * 给你一个数组nums和一个值val，你需要原地移除nums中等于val的元素
     * 并返回移除后数组的长度
     */

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
