package leetcode.suanfa.zcybook._1;

import javax.sound.midi.Soundbank;
import java.util.LinkedList;
import java.util.Stack;

public class _7_GetMaxWindows {

    //生成窗口最大值数组

    public static int[] getMaxWindows(int[] nums, int w) {
        if (nums == null || w < 1 || nums.length < w) {
            return null;
        }
        LinkedList<Integer> window = new LinkedList<>();
        int[] res = new int[nums.length - w + 1];
        int index= 0;
        for (int i = 0; i < nums.length; i++) {
            while (!window.isEmpty() && nums[window.peekFirst()] <= nums[i]) {
                window.pollLast();
            }
            window.addLast(i);
            if (i - w == window.peekFirst()) {
                window.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = nums[window.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 5, 4, 3, 3, 6, 7};
        int[] maxWindows = getMaxWindows(nums, 3);
        for (int maxWindow : maxWindows) {
            System.out.println(maxWindow);
        }
    }
}
