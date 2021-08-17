package leetcode.suanfa.labuladong._1._1_3._1_3_8;

import java.util.Stack;

public class NextGreaterElement2 {

    //下一个更大元素Ⅱ
    /**
     * 比如输入一个数组 [2,1,2,4,3]，你返回数组 [4,2,4,-1,4]。拥有了环形属性，最后一个元素 3 绕了一圈后找到了比自己大的元素 4。
     */

    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n * 2 - 1; i++) {
            while(!stack.isEmpty() && nums[stack.peek() % n] < nums[i % n]) {
                res[stack.pop() % n] = nums[i % n];
            }
            stack.push(i);
        }
        return res;
    }

    public int[] nextGreaterElements2(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = n * 2 - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            res[i % n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % n]);
        }
        return res;
    }
}
